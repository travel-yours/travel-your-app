package com.example.travelyour.domain.contract

import com.example.travelyour.data.response.DestinationResponse
import com.example.travelyour.utils.ResultState
import kotlinx.coroutines.flow.Flow
import java.io.File

interface ImageDetectionUseCaseContract {
    suspend operator fun invoke (
        file:File,
        name: String,
        description:String,
        location:String,
        price:Int,
        facilities:String,
        imageUrl:String):Flow<ResultState<DestinationResponse>>
}