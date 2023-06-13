package com.example.travelyour.domain.contract

import com.example.travelyour.utils.ResultState
import kotlinx.coroutines.flow.Flow

interface SignUpUseCaseContract {
    operator fun invoke(name:String,email:String,password:String):Flow<ResultState<String>>
}