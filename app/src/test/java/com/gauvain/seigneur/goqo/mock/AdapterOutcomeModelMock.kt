package com.gauvain.seigneur.goqo.mock

import com.gauvain.seigneur.goqo.dataAdapter.model.*

object AdapterOutcomeModelMock {

    fun createCurrentUserSuccessOutCome(): PaginedUserReponse =
        PaginedUserReponse(
            info = ResponseInfo(
                seed = "ff7d24c1f433b0d4",
                results = 1,
                page = 1,
                version = "1.3"
            ),
            users = listOf(
                User(
                    pictures = UserPicture(
                        large = "https://randomuser.me/api/portraits/women/58.jpg",
                        medium = "https://randomuser.me/api/portraits/med/women/58.jpg",
                        thumbnail = "https://randomuser.me/api/portraits/thumb/women/58.jpg"
                    ),
                    id = UserId(
                        name= "",
                        value= null
                    ),
                    name = UserName(
                        first= "Ariana",
                        last =  "Cooper"
                    ),
                    email = "ariana.cooper@example.com"
                )
            )
        )

}