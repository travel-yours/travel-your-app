package com.example.travelyour.domain


import com.example.travelyour.data.response.SignIn
import com.example.travelyour.data.response.SignUp
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    fun signUp(name:String, email:String, password: String): Flow<SignUp>

    fun signIn(email:String, password:String): Flow<SignIn>


}