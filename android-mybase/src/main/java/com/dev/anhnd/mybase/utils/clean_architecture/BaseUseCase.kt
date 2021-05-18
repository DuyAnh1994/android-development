package com.dev.anhnd.mybase.utils.clean_architecture

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart

abstract class BaseUseCase<in P, out R> constructor(private val dispatcher: CoroutineDispatcher = Dispatchers.IO) {

    protected abstract suspend fun execute(param: P): Flow<BaseResponse<R>>

    suspend fun invoke(param: P): Flow<BaseResponse<R>> = execute(param).onStart {
        emit(BaseResponse.Loading)
    }.catch { exception ->
        emit(BaseResponse.Error(msg = exception.message))
    }.flowOn(dispatcher)
}
