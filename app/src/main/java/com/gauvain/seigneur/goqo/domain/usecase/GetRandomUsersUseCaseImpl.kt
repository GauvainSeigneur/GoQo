package com.gauvain.seigneur.goqo.domain.usecase

import com.gauvain.seigneur.c.domain.ErrorType
import com.gauvain.seigneur.goqo.domain.Outcome
import com.gauvain.seigneur.goqo.domain.RequestExceptionType
import com.gauvain.seigneur.goqo.domain.model.UserModel
import com.gauvain.seigneur.goqo.domain.provider.GetRandomUsersException
import com.gauvain.seigneur.goqo.domain.provider.GetRandomUsersProvider

internal class GetRandomUsersUseCaseImpl(private val provider: GetRandomUsersProvider) :
    GetRandomUsersUseCase {

    override suspend fun invoke(page:Int, perPage:Int): Outcome<List<UserModel>, ErrorType> {
        return try {
            val result = provider.get(page, perPage)
            Outcome.Success(result)
        } catch (e: GetRandomUsersException) {
            handleException(e)
        }
    }

    private fun handleException(e: GetRandomUsersException): Outcome.Error<ErrorType> =
        when (e.type) {
            RequestExceptionType.UNKNOWN_HOST -> Outcome.Error(ErrorType.ERROR_UNKNOWN_HOST)
            RequestExceptionType.CONNECTION_LOST -> Outcome.Error(ErrorType.ERROR_CONNECTION_LOST)
            RequestExceptionType.UNAUTHORIZED -> Outcome.Error(ErrorType.ERROR_UNAUTHORIZED)
            RequestExceptionType.SERVER_INTERNAL_ERROR -> Outcome.Error(ErrorType.ERROR_INTERNAL_SERVER)
            else -> Outcome.Error(ErrorType.ERROR_UNKNOWN)
        }
}