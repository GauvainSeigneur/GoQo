package com.gauvain.seigneur.goqo.domain.provider

import com.gauvain.seigneur.goqo.domain.RequestExceptionType
import com.gauvain.seigneur.goqo.domain.model.UserModel
import java.lang.Exception

interface GetRandomUsersProvider {
    @Throws(GetRandomUsersException::class)
    fun get(page: Int, perPage: Long): List<UserModel>
}

class GetRandomUsersException(
    val type: RequestExceptionType,
    val description: String? = null
) : Exception()
