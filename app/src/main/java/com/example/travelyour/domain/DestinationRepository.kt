package com.example.travelyour.domain

import com.example.travelyour.data.response.DestinationResponse
import com.example.travelyour.data.response.MlResponse
import kotlinx.coroutines.flow.Flow

interface DestinationRepository {

    fun imageDetection(name:String):Flow<MlResponse>

    fun imageDestination(name:String, description:String, location:String, price:Int, facility:String):Flow<DestinationResponse>
}