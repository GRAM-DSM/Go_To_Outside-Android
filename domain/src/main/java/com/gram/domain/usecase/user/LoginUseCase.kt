package com.gram.domain.usecase.user

import com.gram.domain.parameter.user.LoginParameter
import com.gram.domain.repository.UserRepository
import com.gram.domain.usecase.base.BaseUseCase
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repository: UserRepository,
) : BaseUseCase<LoginParameter, Unit>() {

    override fun invoke(data: LoginParameter) = repository.login(data)
}