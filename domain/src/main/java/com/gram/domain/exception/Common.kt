package com.gram.domain.exception

sealed class CommonException : RuntimeException() {

    class BadRequestException : CommonException()

    class UnauthorizedException : CommonException()

    class UserNotFoundException : CommonException()

    class ForbiddenException : CommonException()

    class NetworkConnectionException : CommonException()

    class TimeoutException : CommonException()
}