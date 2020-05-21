package com.gauvain.seigneur.goqo.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.gauvain.seigneur.goqo.domain.model.UserModel
import com.gauvain.seigneur.goqo.domain.usecase.GetRandomUsersUseCase
import kotlinx.coroutines.CoroutineScope

class RandomUsersDataSourceFactory(
    val scope: CoroutineScope,
    val useCase: GetRandomUsersUseCase
) : DataSource.Factory<Int, UserModel>() {

    val usersLiveDataSource = MutableLiveData<RandomUsersDataSource>()

    override fun create(): DataSource<Int, UserModel> {
        val newsDataSource = RandomUsersDataSource(scope, useCase)
        usersLiveDataSource.postValue(newsDataSource)
        return newsDataSource
    }
}