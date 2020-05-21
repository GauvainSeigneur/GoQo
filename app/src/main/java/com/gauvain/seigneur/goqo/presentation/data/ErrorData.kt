package com.gauvain.seigneur.goqo.presentation.data


data class ErrorData(
    val type: ErrorDataType,
    val title: String? = null
)

enum class ErrorDataType {
    INFORMATIVE,
    RECOVERABLE,
    NOT_RECOVERABLE
}


