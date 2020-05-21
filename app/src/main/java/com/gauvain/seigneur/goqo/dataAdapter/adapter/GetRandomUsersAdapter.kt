package com.gauvain.seigneur.goqo.dataAdapter.adapter

import com.gauvain.seigneur.goqo.dataAdapter.RandomUserService
import com.gauvain.seigneur.goqo.dataAdapter.model.PaginedUserReponse
import com.gauvain.seigneur.goqo.dataAdapter.model.toModel
import com.gauvain.seigneur.goqo.domain.RequestExceptionType
import com.gauvain.seigneur.goqo.domain.model.UserModel
import com.gauvain.seigneur.goqo.domain.provider.GetRandomUsersException
import com.gauvain.seigneur.goqo.domain.provider.GetRandomUsersProvider
import retrofit2.Response

class GetRandomUsersAdapter(private val service: RandomUserService) :
    GetRandomUsersProvider {

    override fun get(page: Int, perPage: Long): List<UserModel> {
        val result = runCatching {
            service.getPaginedUsers(page, perPage).execute()
        }.onFailure {
            throw GetRandomUsersException(RequestExceptionType.UNKNOWN_HOST, it.message)
        }
        return handleResult(result)
    }


    private fun handleResult(result: Result<Response<PaginedUserReponse>>): List<UserModel> {
        return result.run {
            getOrNull()?.body().let { response ->
                if (response?.error != null) {
                    throw GetRandomUsersException(RequestExceptionType.UNAUTHORIZED, response.error)
                } else {
                    response?.users?.map {
                        it.toModel()
                    }
                } ?: throw GetRandomUsersException(RequestExceptionType.BODY_NULL, "Body null")
            }
        }
    }
}