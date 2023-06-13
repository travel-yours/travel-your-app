package com.example.travelyour.data.response

data class DestinationResponse(
    val description: String,
    val facilities: List<String>,
    val imageUrl: String,
    val location: String,
    val name: String,
    val price: Int
)
