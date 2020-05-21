package com.gauvain.seigneur.goqo.dataAdapter.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("name")
    val name: UserName,
    @SerializedName("id")
    val id: UserId,
    val pictures: UserPicture
)

data class UserName(
    @SerializedName("first")
    val first: String,
    @SerializedName("lasyt")
    val last: String
)

data class UserId(
    @SerializedName("name")
    val name: String,
    @SerializedName("value")
    val value: String
)

data class UserPicture(
    @SerializedName("large")
    val large: String,
    @SerializedName("medium")
    val medium: String,
    @SerializedName("thumbnail")
    val thumbnail: String
)
