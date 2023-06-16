package com.example.travelyour.data.source.network


import com.example.travelyour.data.response.DestinationResponse
import com.example.travelyour.data.response.SignIn
import com.example.travelyour.data.response.SignUp
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.*

interface ApiServices {
    @POST("/auth/signup")
    suspend fun signupUser(@Body requestBody:HashMap<String, String>): SignUp

    @POST("/auth/signin")
    suspend fun signinUser(
        @Body requestBody: HashMap<String, String>): SignIn

    @Multipart
    @POST("https://travelyours-ml-model-4zcm2uhcpq-as.a.run.app/")
    suspend fun imageDetection(
        @Part imageCamera: MultipartBody.Part,
        @Part("name") name: RequestBody,
        @Part("description") description: RequestBody,
        @Part("location") location: RequestBody,
        @Part("price") price: RequestBody,
        @Part("facilities") facilities: RequestBody,
        @Part("imageUrl") imageUrl: RequestBody
    ): DestinationResponse
    @GET("https://travelyours-api-4zcm2uhcpq-as.a.run.app/destination/%7Buid%7D")
    suspend fun imageDestination(@Body requestBody: HashMap<String, String>):DestinationResponse
}


