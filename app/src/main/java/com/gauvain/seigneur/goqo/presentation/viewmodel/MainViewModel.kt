package com.gauvain.seigneur.goqo.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.gauvain.seigneur.goqo.domain.model.toData
import com.gauvain.seigneur.goqo.domain.usecase.GetRandomUsersUseCase
import com.gauvain.seigneur.goqo.presentation.data.UserItemData
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext


class MainViewModel(private val useCase: GetRandomUsersUseCase) : ViewModel(), CoroutineScope {

    //Define coroutine context
    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    override fun onCleared() {
        job.cancel()
    }

    private val config = PagedList.Config.Builder()
        .setPageSize(5)
        .setEnablePlaceholders(false)
        .build()

    var usersList: LiveData<PagedList<UserItemData>>? = null

    fun fetchUsersFromService() {
        val dataSourceFactory = RandomUsersDataSourceFactory(
            viewModelScope,
            useCase
        )

        usersList = LivePagedListBuilder<Int, UserItemData>(dataSourceFactory.map {
            it.toData()
        }, config).build()
    }

}
