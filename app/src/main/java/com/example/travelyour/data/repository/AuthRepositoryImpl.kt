package com.example.travelyour.data.repository


import com.example.travelyour.data.source.network.ApiServices
import com.example.travelyour.domain.AuthRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class AuthRepositoryImpl(private val api:ApiServices): AuthRepository {
    override fun signUp(name: String, email: String, password: String) = flow {
        emit(
            api.signupUser(
                hashMapOf(
                    Pair("name", name),
                    Pair("email", email),
                    Pair("password", password)
                )
            )
        )
    }.flowOn(Dispatchers.IO)

    override fun signIn(email: String, password: String) = flow {
        emit(
            api.signinUser(
                hashMapOf(
                    Pair("email", email),
                    Pair("password", password)
                )
            )
        )
    }.flowOn(Dispatchers.IO)

}