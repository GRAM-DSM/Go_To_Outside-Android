package com.gram.presentation.viewmodel.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gram.domain.exception.CommonException
import com.gram.domain.exception.CommonException.*
import com.gram.domain.parameter.user.LoginParameter
import com.gram.domain.usecase.user.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
) : ViewModel() {

    private val _eventFlow = MutableStateFlow<Event>(Event.Unauthorized)
    val eventFlow: StateFlow<Event> = _eventFlow

    fun login(
        accountId: String,
        password: String,
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching {
                loginUseCase.invoke(
                    LoginParameter(
                        accountId,
                        password,
                    )
                )
            }.onSuccess {
                emitEvent(
                    Event.LoginSuccess,
                )
            }.onFailure {
                handleException(
                    it as CommonException,
                )
            }
        }
    }

    private fun emitEvent(event: Event) {
        viewModelScope.launch(Dispatchers.Default) {
            _eventFlow.emit(
                event,
            )
        }
    }

    private fun handleException(
        exception: CommonException,
    ) {
        emitEvent(
            when (exception) {
                is BadRequestException -> Event.BadRequest
                is UnauthorizedException -> Event.Unauthorized
                is UserNotFoundException -> Event.UserNotFound
                is ForbiddenException -> Event.Forbidden
                is NetworkConnectionException -> Event.NoNetworkConnection
                is TimeoutException -> Event.Timeout
            }
        )
    }

    sealed class Event {
        object BadRequest : Event()
        object LoginSuccess : Event()
        object Unauthorized : Event()
        object UserNotFound : Event()
        object Forbidden : Event()
        object NoNetworkConnection : Event()
        object Timeout : Event()
    }
}