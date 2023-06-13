package com.example.travelyour.domain.contract

import com.example.travelyour.utils.ResultState
import kotlinx.coroutines.flow.Flow


interface SignInUseCaseContract {
    operator fun invoke(email:String,password:String): Flow<ResultState<String>>
}