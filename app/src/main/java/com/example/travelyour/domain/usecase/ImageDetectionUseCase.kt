package com.example.travelyour.domain.usecase


import com.example.travelyour.data.response.DestinationResponse
import com.example.travelyour.domain.DestinationRepository
import com.example.travelyour.domain.contract.ImageDetectionUseCaseContract
import com.example.travelyour.utils.ResultState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.File

class ImageDetectionUseCase(private val destinationRepository: DestinationRepository) : ImageDetectionUseCaseContract {

    override suspend operator fun invoke(
        imageCamera: File,
        name: String,
        description: String,
        location: String,
        price: Int,
        facilities: String,
        imageUrl: String
    ): Flow<ResultState<DestinationResponse>> = flow {
        emit(ResultState.Loading)
        try {
            val response = destinationRepository.imageDetection(
                imageCamera,
                name,
                description,
                location,
                price,
                facilities,
                imageUrl
            )
            emit(ResultState.Success(response))
        } catch (e: Exception) {
            emit(ResultState.Error(e.message.toString()))
        }
    }
}



