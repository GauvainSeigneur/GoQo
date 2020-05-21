package com.gauvain.seigneur.goqo.domain.model

import com.gauvain.seigneur.goqo.R
import com.gauvain.seigneur.goqo.presentation.StringPresenter
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
    name = StringPresenter(R.string.user_first_last_name, this.firstName, this.lastName),
    picture = this.picture,
    email = this.email
)
