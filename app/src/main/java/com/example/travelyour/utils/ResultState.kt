package com.example.travelyour.utils

sealed class ResultState<out T> (
    val data: T? = null,
    val message: String = "",
    val isSuccess: Boolean = false
) {
    class Success<out T:Any?>(data: T) : ResultState<T>(data)

    object Loading: ResultState<Nothing>()

    object Idle: ResultState<Nothing>()

    class Error<T>(message: String, data: T? = null) :
        ResultState<T>(data, message)
}
