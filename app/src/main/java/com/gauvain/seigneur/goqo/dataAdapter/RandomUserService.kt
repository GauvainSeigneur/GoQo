package com.gauvain.seigneur.goqo.dataAdapter

import com.gauvain.seigneur.goqo.dataAdapter.model.PaginedUserReponse
import retrofit2.Call
import retrofit2.http.*

interface RandomUserService {

    @GET("api/")
    fun getPaginedUsers(@Query("page") page: Int,
                        @Query("results") results: Int): Call<PaginedUserReponse>

}