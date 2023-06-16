package com.example.travelyour.presentation.auth.signin

import com.example.travelyour.utils.ResultState

data class SignInViewState(
    var email:String ="",
    var password: String = "",

    var emailError: Boolean = false,
    var passwordError: Boolean = false,
    val isLoading: Boolean = false,
    val resultVerifyUser: ResultState<String> = ResultState.Idle
)
