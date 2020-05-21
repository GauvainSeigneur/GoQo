package com.gauvain.seigneur.goqo.domain

sealed class Outcome<out T : Any, out E : Any> {
    data class Success<out T : Any>(val model: T) : Outcome<T, Nothing>()
    data class Error<out E : Any>(val error: E) : Outcome<Nothing, E>()
}