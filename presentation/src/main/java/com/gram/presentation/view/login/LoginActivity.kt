package com.gram.presentation.view.login

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.gram.domain.entity.user.LoginEntity
import com.gram.domain.entity.user.LoginEntity.Authority.*
import com.gram.presentation.R
import com.gram.presentation.base.BaseActivity
import com.gram.presentation.databinding.ActivityLoginBinding
import com.gram.presentation.util.*
import com.gram.presentation.util.SharedPreferenceKeys.AUTHORITY
import com.gram.presentation.util.SharedPreferenceKeys.IS_LOGGED_IN
import com.gram.presentation.view.student.StudentMainActivity
import com.gram.presentation.view.teacher.TeacherMainActivity
import com.gram.presentation.viewmodel.login.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : BaseActivity<ActivityLoginBinding>(
    R.layout.activity_login,
) {

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        checkLoggedIn()

        observeEvents()
    }

    // 자동로그인 로직
    private fun checkLoggedIn() {
        sharedPreferences.run {
            if ((this?.getBoolean(
                    IS_LOGGED_IN,
                    false,
                ) == true).also {
                    println(it)
                }
            ) {
                moveToMainActivity(
                    convertStringToAuthorityClass(
                        this?.getString(
                            AUTHORITY,
                            "STUDENT",
                        )!!
                    )
                )
            }
        }
    }

    private fun convertStringToAuthorityClass(string: String): LoginEntity.Authority {
        return when (string) {
            STUDENT.toString() -> {
                STUDENT
            }
            else -> {
                TEACHER
            }
        }
    }

    private fun observeEvents() {
        viewModel.loginEntity.observe(
            this,
        ) {
            Log.e(
                "Login", """
                    access_token = ${it.access_token}
                    refresh_token = ${it.refresh_token}
                    authority = ${it.authority}
                """.trimIndent()
            )
        }

        viewModel.loginType.observe(
            this,
        ) {
            moveToMainActivity(it)
        }
    }

    private fun moveToMainActivity(authority: LoginEntity.Authority) {
        startActivityFinishingCurrentActivityInvokingFunction(
            this,
            when (authority) {
                STUDENT -> StudentMainActivity::class.java
                TEACHER -> TeacherMainActivity::class.java
            },
        ) { setLoggedIn(authority) }
    }

    override fun initView() {
        with(binding) {
            btnLoginNext.setOnClickListener {
                val id = includedLoginLabel.etLabelLoginId.text.toString()
                val password = includedLoginLabel.etLabelLoginPassword.text.toString()
                if (id.isNotBlank() && password.isNotBlank()) {
                    viewModel.login(
                        id,
                        password,
                    )
                }
            }

            includedLoginHeader.run {
                tvHeaderPrimary.text = getString(R.string.login_go_to_outside)
                tvHeaderSecondary.text = getString(R.string.login)
            }
        }
    }
}