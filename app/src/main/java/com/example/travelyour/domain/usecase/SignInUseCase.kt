package com.example.travelyour.domain.usecase

import com.example.travelyour.domain.AuthRepository
import com.example.travelyour.domain.UserPreferenceRepository
import com.example.travelyour.domain.contract.SignInUseCaseContract
import com.example.travelyour.domain.entity.UserEntity
import com.example.travelyour.utils.ResultState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

class SignInUseCase(
    private val userPreferenceRepository: UserPreferenceRepository,
    private val authRepository: AuthRepository,
) :SignInUseCaseContract{
    override fun invoke(email: String, password: String): Flow<ResultState<String>> =
        flow {
            emit(ResultState.Loading)
            authRepository.signIn(email,password).catch {
                emit(ResultState.Error(it.message.toString()))
            }.collect{
                result ->
                if (result.error){
                    emit(ResultState.Error(result.message))
                }else{
                    result.data.let {
                        userPreferenceRepository.saveUser(
                            UserEntity(
                                it.userId ?:"",
                                it.nama ?:"",
                                it.token ?:""
                            )
                        )
                    }
                    emit(ResultState.Success(result.message))
                }
        }
    }
}