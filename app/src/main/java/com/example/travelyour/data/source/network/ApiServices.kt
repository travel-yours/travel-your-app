package com.example.travelyour.data.source.network


import com.example.travelyour.data.response.DestinationResponse
import com.example.travelyour.data.response.MlResponse
import com.example.travelyour.data.response.SignIn
import com.example.travelyour.data.response.SignUp
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiServices {
    @POST("/auth/signup")
    suspend fun signupUser(@Body requestBody:HashMap<String, String>): SignUp

    @POST("/auth/signin")
    suspend fun signinUser(
        @Body requestBody: HashMap<String, String>): SignIn
    @POST("https://travelyours-ml-model-4zcm2uhcpq-as.a.run.app/")
    suspend fun imageDetection(@Body requestBody: HashMap<String, String>):MlResponse
    @GET("https://travelyours-api-4zcm2uhcpq-as.a.run.app/destination/%7Buid%7D")
    suspend fun imageDestination(@Body requestBody: HashMap<String, String>):DestinationResponse
}


