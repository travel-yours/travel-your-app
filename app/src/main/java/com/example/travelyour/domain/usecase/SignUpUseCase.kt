package com.example.travelyour.domain.usecase

import com.example.travelyour.domain.AuthRepository
import com.example.travelyour.domain.contract.SignUpUseCaseContract
import com.example.travelyour.utils.ResultState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class SignUpUseCase (
    private val authRepository: AuthRepository
        ):SignUpUseCaseContract{

    override operator fun invoke(
        name:String,
        email:String,
        password:String
    ): Flow<ResultState<String>> =
        flow {
            emit(ResultState.Loading)
            authRepository.signUp(
                name,email,password
            ).catch {
                emit(ResultState.Error(it.message.toString()))
            }.collect{ result ->
               if (result != null){
                   if (result.success) {
                       emit(ResultState.Error(result.message))
                   }
               }else{
                   emit(ResultState.Error("Sign Up Failed"))
               }
            }
        }
}