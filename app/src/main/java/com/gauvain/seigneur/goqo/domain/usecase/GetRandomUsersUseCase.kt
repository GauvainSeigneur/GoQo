package com.gauvain.seigneur.goqo.domain.usecase

import com.gauvain.seigneur.c.domain.ErrorType
import com.gauvain.seigneur.goqo.domain.Outcome
import com.gauvain.seigneur.goqo.domain.model.UserModel
import com.gauvain.seigneur.goqo.domain.provider.GetRandomUsersProvider

interface GetRandomUsersUseCase {
    suspend fun invoke(page:Int, perPage:Int): Outcome<List<UserModel>, ErrorType>

    companion object {
        fun create(provider: GetRandomUsersProvider): GetRandomUsersUseCase =
            GetRandomUsersUseCaseImpl(provider)
    }
}