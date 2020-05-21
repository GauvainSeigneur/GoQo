package com.gauvain.seigneur.goqo.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.gauvain.seigneur.goqo.domain.Outcome
import com.gauvain.seigneur.goqo.domain.model.UserModel
import com.gauvain.seigneur.goqo.domain.usecase.GetRandomUsersUseCase
import com.gauvain.seigneur.goqo.presentation.data.ErrorData
import com.gauvain.seigneur.goqo.presentation.data.ErrorDataType
import com.gauvain.seigneur.goqo.presentation.data.LoadingState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RandomUsersDataSource(
    val scope: CoroutineScope,
    val useCase: GetRandomUsersUseCase
) : PageKeyedDataSource<Int, UserModel>() {

    val initialLoadingData = MutableLiveData<LoadingState>()
    val initialError = MutableLiveData<ErrorData>()

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, UserModel>
    ) {
        scope.launch(Dispatchers.Main) {
            val result = withContext(Dispatchers.IO) {
                useCase.invoke(1, params.requestedLoadSize)
            }
            initialLoadingData.value = LoadingState.IS_LOADING
            when (result) {
                is Outcome.Success -> {
                    initialLoadingData.value = LoadingState.IS_LOADED
                    callback.onResult(result.model, null, 2)
                }
                is Outcome.Error -> {
                    initialError.value = ErrorData(
                        ErrorDataType.RECOVERABLE,
                        "Retry"
                    )
                }
            }
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, UserModel>) {
        scope.launch(Dispatchers.Main) {
            val result = withContext(Dispatchers.IO) {
                useCase.invoke(params.key, params.requestedLoadSize)
            }
            when (result) {
                is Outcome.Success -> {
                    callback.onResult(result.model, params.key + 1)
                }
                is Outcome.Error -> {
                }
            }
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, UserModel>) {
    }
}