package com.example.travelyour.data.repository

import com.example.travelyour.data.response.DestinationResponse
import com.example.travelyour.data.response.MlResponse
import com.example.travelyour.data.source.network.ApiServices
import com.example.travelyour.domain.DestinationRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File

class DestinationRepositoryImpl(private val api: ApiServices) : DestinationRepository {

    override suspend fun imageDetection(
        imageCamera: File,
        name: String,
        description: String,
        location: String,
        price: Int,
        facilities: String,
        imageUrl: String
    ): DestinationResponse {
        val requestFile = imageCamera.asRequestBody("image/*".toMediaTypeOrNull())
        val filePart = MultipartBody.Part.createFormData("imageCamera", imageCamera.name, requestFile)

        return api.imageDetection(
            filePart,
            createRequestBody(name),
            createRequestBody(description),
            createRequestBody(location),
            createRequestBody(price.toString()),
            createRequestBody(facilities),
            createRequestBody(imageUrl)
        )
    }
    private fun createRequestBody(value: String): RequestBody {
        return RequestBody.create("text/plain".toMediaTypeOrNull(), value)
    }
}







// override fun imageDetection(
//        name: String,
//        description: String,
//        location: String,
//        price: Int,
//        facility: String
//    ): Flow<DestinationResponse> = flow {
//        emit(
//            api.imageDetection(
//                hashMapOf(
//                    Pair("name",name),
//                    Pair("description", description),
//                    Pair("location", location),
//                    Pair("price", price.toString()),
//                    Pair("facility",facility)
//                )
//            )
//        )
//    }.flowOn(Dispatchers.IO)

    // override fun imageDetection(file: File, name: String)= flow {
    //        val requestBody = MultipartBody.Part.createFormData(
    //            "photo", file.name, file.asRequestBody("image/jpeg".toMediaTypeOrNull())
    //        )
    //        val name = name.toRequestBody("text/plain".toMediaTypeOrNull())
    //        emit(api.imageDetection(requestBody,name))
    //    }.flowOn(Dispatchers.IO)

