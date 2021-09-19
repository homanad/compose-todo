package com.homanad.android.compose.domain.common

abstract class UseCaseWithParam<in P, out T> {

    suspend operator fun invoke(param: P): T = create(param)

    abstract suspend fun create(param: P): T
}