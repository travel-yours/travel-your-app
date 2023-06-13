package com.example.travelyour.domain.contract

import com.example.travelyour.utils.ResultState
import kotlinx.coroutines.flow.Flow

interface ImageDetectionUseCaseContract {
    operator fun invoke (name:String):Flow<ResultState<String>>
}