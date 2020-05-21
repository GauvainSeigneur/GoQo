package com.gauvain.seigneur.goqo.mock

import com.gauvain.seigneur.goqo.dataAdapter.model.PaginedUserReponse
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken

object ResponseGsonObjectMock {

    fun createsuccessResponse(): PaginedUserReponse {
        val type = object : TypeToken<PaginedUserReponse>() {
        }.type
        return GsonBuilder().create().fromJson(
            """
             {
                "results": [
                    {
                        "gender": "female",
                        "name": {
                            "title": "Mrs",
                            "first": "Ariana",
                            "last": "Cooper"
                        },
                        "location": {
                            "street": {
                                "number": 1763,
                                "name": "Pine Hill Road"
                            },
                            "city": "Upper Hutt",
                            "state": "Northland",
                            "country": "New Zealand",
                            "postcode": 38209,
                            "coordinates": {
                                "latitude": "63.3785",
                                "longitude": "115.7304"
                            },
                            "timezone": {
                                "offset": "+5:30",
                                "description": "Bombay, Calcutta, Madras, New Delhi"
                            }
                        },
                        "email": "ariana.cooper@example.com",
                        "login": {
                            "uuid": "115b2ad8-5a73-41ea-8e54-24419ff3b45a",
                            "username": "crazycat378",
                            "password": "federal",
                            "salt": "NBoh5Oa4",
                            "md5": "e3b4cd522afae7dc38d6b8909c1ec6dc",
                            "sha1": "15e66b1500b133b57637d450218e35a3cfcc9b3b",
                            "sha256": "2ad55de8ddbf6a6cc9f8394ad815da31744b3cd870a9bd12d31996bfbbdded93"
                        },
                        "dob": {
                            "date": "1958-05-11T05:15:33.119Z",
                            "age": 62
                        },
                        "registered": {
                            "date": "2004-02-05T15:04:39.251Z",
                            "age": 16
                        },
                        "phone": "(992)-723-6187",
                        "cell": "(606)-408-4143",
                        "id": {
                            "name": "",
                            "value": null
                        },
                        "picture": {
                            "large": "https://randomuser.me/api/portraits/women/58.jpg",
                            "medium": "https://randomuser.me/api/portraits/med/women/58.jpg",
                            "thumbnail": "https://randomuser.me/api/portraits/thumb/women/58.jpg"
                        },
                        "nat": "NZ"
                    }
                ],
                "info": {
                    "seed": "ff7d24c1f433b0d4",
                    "results": 1,
                    "page": 1,
                    "version": "1.3"
                }
            }
                """.trimIndent(), type
        )
    }

    fun createMessageResponse(): PaginedUserReponse {
        val type = object : TypeToken<PaginedUserReponse>() {
        }.type
        return GsonBuilder().create().fromJson(
            """
             {
                "error": "oops"
            }
                """.trimIndent(), type
        )
    }

}