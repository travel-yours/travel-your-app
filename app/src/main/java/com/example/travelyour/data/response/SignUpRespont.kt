package com.example.travelyour.data.response

data class SignUp(
    val data: DataSignup,
    val success:Boolean,
    val message: String
)

data class DataSignup(
    val name:String,
    val email:String,
    val password:String,
)
