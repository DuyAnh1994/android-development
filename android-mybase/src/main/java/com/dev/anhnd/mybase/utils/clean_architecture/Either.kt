package com.dev.anhnd.mybase.utils.clean_architecture

import retrofit2.Call

sealed class Either<out L, out R> {

    data class Left<out L>(val l: L) : Either<L, Nothing>()

    data class Right<out R>(val r: R) : Either<Nothing, R>()

    val isLeft get() = this is Left<L>

    val isRight get() = this is Right<R>

    fun <L> left(l: L) = Left(l)

    fun <R> right(r: R) = Right(r)

    fun fold(fnL: (L) -> Any, fnR: (R) -> Any): Any = when (this) {
        is Left -> fnL(l)
        is Right -> fnR(r)
    }
}


fun <T, R> request(
    call: Call<T>,
    transform: (T) -> R,
    default: T
): Either<Failure, R> {
    return try {
        val response = call.execute()
        when (response.isSuccessful) {
            true -> Either.Right(transform((response.body() ?: default)))
            false -> Either.Left(Failure.ServerError)
        }
    } catch (exception: Throwable) {
        Either.Left(Failure.ServerError)
    }
}
