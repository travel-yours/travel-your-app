package com.example.travelyour.data.response

data class SignIn(
    val `data`: Data,
    val error: Boolean,
    val message: String
)

data class Data(
    val createdAt: String,
    val email: String,
    val nama: String,
    val noHP: Long,
    val userId: String,
    val password: String,
    val token: String
)