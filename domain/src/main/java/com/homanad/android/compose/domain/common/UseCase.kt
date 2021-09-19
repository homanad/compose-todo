package com.homanad.android.compose.domain.common

abstract class UseCase<T> {

    suspend operator fun invoke(): T = create()

    abstract suspend fun create(): T
}