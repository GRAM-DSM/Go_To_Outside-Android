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


        lifecycleScope.launch(Dispatchers.Default) {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.eventFlow.collect { event ->
                    handleEvent(
                        event,
                    )
                }
            }
        }
    }

    private fun handleEvent(event: LoginViewModel.Event) {
        when (event) {
            //LoginViewModel.Event.BadRequest -> TODO()
            //LoginViewModel.Event.Forbidden -> TODO()
            LoginViewModel.Event.LoginSuccess -> Log.e("HANDLE_EVENT", "SUCCESS")
            LoginViewModel.Event.NoNetworkConnection -> Log.e("NO_CONNECTION", "handleEvent: ", )
//            LoginViewModel.Event.Timeout -> TODO()
/*            LoginViewModel.Event.Unauthorized -> TODO()
            LoginViewModel.Event.UserNotFound -> */
            else -> {

            }
        }
    }

    override fun initView() {

    }
}