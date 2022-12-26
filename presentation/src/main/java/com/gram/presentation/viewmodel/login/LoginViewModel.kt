package com.gram.presentation.viewmodel.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gram.domain.entity.user.LoginEntity
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

    private val _loginEntity = MutableLiveData<LoginEntity>()
    val loginEntity: LiveData<LoginEntity>
        get() = _loginEntity

    // Temporary login Function
    internal fun login(
        accountId: String,
        password: String,
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching {
                loginUseCase.invoke(
                    LoginParameter(
                    )
                )
            }.onSuccess {
                _loginEntity.postValue(it)
            }.onFailure {
                Log.e("Login", "login: failure")
            }
        }
    }


    /* fun login(
        accountId: String,
        password: String,
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching {
                Log.e("Login", "login: ")
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
                Log.e("Login", "login success")
            }.onFailure {*//*
                handleException(
                    it as CommonException,
                )*//*
                Log.e("Login", "login failure")
            }
        }
    }*/

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
                is ConflictException -> Event.Conflict
                is ServerException -> Event.Server
                is UnknownException -> Event.Unknown
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
        object Conflict : Event()
        object Server : Event()
        object Unknown : Event()
    }
}