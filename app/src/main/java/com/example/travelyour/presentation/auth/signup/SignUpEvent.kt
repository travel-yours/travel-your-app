package com.example.travelyour.presentation.auth.signup

sealed class SignUpEvent{
    data class NameChanged(val name:String):SignUpEvent()
    data class EmailChanged(val email:String):SignUpEvent()
    data class PasswordChanged(val password:String):SignUpEvent()

    object RegisterButton:SignUpEvent()
}
