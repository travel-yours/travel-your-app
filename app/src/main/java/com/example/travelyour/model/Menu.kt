package com.example.travelyour.model

import com.example.travelyour.R

data class Menu(
    val image: Int,
    val title: String,
)

val dummyMenu = listOf(
    Menu(R.drawable.stay, "StayCation"),
    Menu(R.drawable.gunung, "Hiking"),
    Menu(R.drawable.pantai, "Pantai")
)

val dummyBestSellerMenu = dummyMenu.shuffled()
