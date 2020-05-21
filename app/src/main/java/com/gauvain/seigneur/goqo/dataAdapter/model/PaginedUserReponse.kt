package com.gauvain.seigneur.goqo.dataAdapter.model

import com.google.gson.annotations.SerializedName

data class PaginedUserReponse(
    @SerializedName("results")
    val users: List<User>,
    @SerializedName("info")
    val info: ResponseInfo
)

data class ResponseInfo(
    @SerializedName("seed")
    val seed: String,
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: Int,
    @SerializedName("version")
    val version: String
)
