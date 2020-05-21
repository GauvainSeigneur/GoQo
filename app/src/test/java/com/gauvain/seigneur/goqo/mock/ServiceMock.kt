package com.gauvain.seigneur.goqo.mock

import com.gauvain.seigneur.goqo.dataAdapter.RandomUserService
import com.gauvain.seigneur.goqo.dataAdapter.model.PaginedUserReponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.mock.BehaviorDelegate
import retrofit2.mock.Calls
import retrofit2.mock.MockRetrofit

object ServiceMock {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://favqs.com/api/")
        .build()
    val behaviorDelegate: BehaviorDelegate<RandomUserService> =
        MockRetrofit.Builder(retrofit).build().create(RandomUserService::class.java)

    fun createServiceThatFail(t: Throwable) =
        object : RandomUserService {
            override fun getPaginedUsers(page: Int, results: Int): Call<PaginedUserReponse> {
                return behaviorDelegate.returning(Calls.failure<Throwable>(t))
                    .getPaginedUsers(0, 0)
            }

        }

    fun createServiceWithResponses(response: Any? = null) =
        object : RandomUserService {
            override fun getPaginedUsers(page: Int, results: Int): Call<PaginedUserReponse> {
                return behaviorDelegate.returningResponse(response).getPaginedUsers(0, 0)
            }

        }
}