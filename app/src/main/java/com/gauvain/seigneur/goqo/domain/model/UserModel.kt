package com.gauvain.seigneur.goqo.domain.model

import com.gauvain.seigneur.goqo.presentation.data.UserItemData

data class UserModel(
    val id: String,
    val firstName: String,
    val lastName: String,
    val picture: String,
    val email: String
)

fun UserModel.toData() : UserItemData =  UserItemData(
    id = this.id,
    firstName = this.firstName,
    lastName = this.lastName,
    picture = this.picture,
    email = this.email
)
