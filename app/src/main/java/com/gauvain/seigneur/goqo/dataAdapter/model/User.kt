package com.gauvain.seigneur.goqo.dataAdapter.model

import com.gauvain.seigneur.goqo.domain.model.UserModel
import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("name")
    val name: UserName,
    @SerializedName("id")
    val id: UserId,
    val pictures: UserPicture
)

fun User.toModel() : UserModel = UserModel(
    id = this.id.value,
    firstName = this.name.first,
    lastName =  this.name.last,
    picture = this.pictures.medium
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

