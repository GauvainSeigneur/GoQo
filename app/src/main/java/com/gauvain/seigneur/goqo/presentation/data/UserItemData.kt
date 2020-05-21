package com.gauvain.seigneur.goqo.presentation.data

import com.gauvain.seigneur.goqo.presentation.StringPresenter

data class UserItemData(
    val id: String,
    val name: StringPresenter,
    val email: String,
    val picture: String
)
