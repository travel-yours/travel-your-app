package com.example.travelyour.data.response

data class DestinationResponse(
    val name: String,
    val description: String,
    val location: String,
    val price: Int,
    val facilities: List<String>,
    val imageUrl: String,

)
