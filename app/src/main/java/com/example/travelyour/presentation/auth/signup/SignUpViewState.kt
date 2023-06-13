package com.example.travelyour.presentation.auth.signup

import com.example.travelyour.utils.ResultState

data class SignUpViewState(
    val resultSignUpUser: ResultState<String> = ResultState.Idle(),
    var name:String = "",
    var email:String = "",
    var password:String = "",

    var nameError: Boolean = false,
    var emailError:Boolean = false,
    var passwordError:Boolean = false,
    val resultVerifyUser: ResultState<String> = ResultState.Idle()
)
