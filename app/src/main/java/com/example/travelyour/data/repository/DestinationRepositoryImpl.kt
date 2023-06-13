package com.example.travelyour.data.repository

import com.example.travelyour.data.response.DestinationResponse
import com.example.travelyour.data.source.network.ApiServices
import com.example.travelyour.domain.DestinationRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class DestinationRepositoryImpl(private val api: ApiServices):DestinationRepository {

    override fun imageDetection(name: String) = flow {
        emit(
            api.imageDetection(
                hashMapOf(
                    Pair("name", name)
                )
            )
        )
    }.flowOn(Dispatchers.IO)

    override fun imageDestination(
        name: String,
        description: String,
        location: String,
        price: Int,
        facility: String
    ) = flow {
        emit(
            api.imageDestination(
                hashMapOf(
                    Pair("name",name),
                    Pair("description", description),
                    Pair("location", location),
                    Pair("price", price.toString()),
                    Pair("facility",facility)
                )
            )
        )
    }.flowOn(Dispatchers.IO)


}