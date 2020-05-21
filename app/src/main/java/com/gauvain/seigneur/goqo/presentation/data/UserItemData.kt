package com.gauvain.seigneur.goqo.presentation.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserItemData(
    val id: String,
    val firstName: String,
    val lastName: String,
    val email: String,
    val picture: String
):Parcelable
