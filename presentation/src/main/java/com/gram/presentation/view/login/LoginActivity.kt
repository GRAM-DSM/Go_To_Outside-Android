package com.gram.presentation.view.login

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.gram.domain.entity.user.LoginEntity
import com.gram.domain.entity.user.LoginEntity.Authority.*
import com.gram.presentation.R
import com.gram.presentation.base.BaseActivity
import com.gram.presentation.databinding.ActivityLoginBinding
import com.gram.presentation.util.StartActivityUtils
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

        observeEvents()
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
        when (authority) {
            STUDENT -> {
                StartActivityUtils.startActivity(
                    this,
                    StudentMainActivity::class.java,
                )
            }
            TEACHER -> {
                StartActivityUtils.startActivity(
                    this,
                    TeacherMainActivity::class.java,
                )
            }
        }
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
                tvHeaderPrimary.text = "GoToOutside"
                tvHeaderSecondary.text = "로그인"
            }
        }
    }
}