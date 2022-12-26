package com.gram.presentation.view.login

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.gram.presentation.R
import com.gram.presentation.base.BaseActivity
import com.gram.presentation.databinding.ActivityLoginBinding
import com.gram.presentation.viewmodel.login.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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
    }

    override fun initView() {
        with(binding) {
            btnLoginNext.setOnClickListener {
                val id = includedLoginLabel.etLabelLoginId.text.toString()
                val password = includedLoginLabel.etLabelLoginPassword.text.toString()
                if (id.isNotBlank() && password.isNotBlank()) {
                    btnLoginNext.setOnClickListener {
                        viewModel.login(
                            id,
                            password,
                        )
                    }
                }
            }
        }
    }
}