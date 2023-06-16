package com.example.travelyour.domain

import com.example.travelyour.data.response.DestinationResponse
import com.example.travelyour.data.response.MlResponse
import kotlinx.coroutines.flow.Flow
import java.io.File

interface DestinationRepository {
    suspend fun imageDetection(
        imageCamera: File,
        name: String,
        description: String,
        location: String,
        price: Int,
        facilities: String,
        imageUrl: String
    ): DestinationResponse
}



