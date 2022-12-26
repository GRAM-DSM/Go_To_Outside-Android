package com.gram.domain.usecase.base

abstract class BaseUseCase<I, O> {
    abstract suspend operator fun invoke(data: I): O
}