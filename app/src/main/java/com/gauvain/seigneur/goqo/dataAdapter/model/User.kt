package com.gauvain.seigneur.goqo.dataAdapter.model

import com.gauvain.seigneur.goqo.domain.model.UserModel
import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("name")
    val name: UserName,
    @SerializedName("id")
    val id: UserId,
    val pictures: UserPicture?,
    @SerializedName("email")
    val email: String
)

fun User.toModel() : UserModel = UserModel(
    id = this.id.value?:"randomTodo",
    firstName = this.name.first,
    lastName =  this.name.last,
    picture = this.pictures?.large?: this.pictures?.medium?: this.pictures?.thumbnail?: "" ,
    email = this.email
)


data class UserName(
    @SerializedName("first")
    val first: String,
    @SerializedName("last")
    val last: String
)

data class UserId(
    @SerializedName("name")
    val name: String?,
    @SerializedName("value")
    val value: String?
)

data class UserPicture(
    @SerializedName("large")
    val large: String?,
    @SerializedName("medium")
    val medium: String?,
    @SerializedName("thumbnail")
    val thumbnail: String?
)

