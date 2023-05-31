package com.example.travelyour.presentation.quesionerpage

import BackgroundPage
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.travelyour.external.theme.primary2
import com.example.travelyour.external.widget.ButtonQuest
import com.example.travelyour.external.widget.CircleButton
import com.example.travelyour.external.widget.TextHeadline
import com.example.travelyour.external.widget.TextTitle

@Composable
fun TypesPlacePage() {
    BackgroundPage(
        icon = {
            CircleButton(
                onClick = { /*TODO*/ },
                size = 50.dp,
            backgroundColor = primary2,
            blurRadius = 30.dp)
        }) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextTitle(text = "Jenis Tempat")
            TextHeadline(text = "Apakah anda lebih tertarik dengan tempat-tempat ramai (publik) atau yang lebih pribadi ?")
            ButtonQuest(
                onClick = { /*TODO*/ },
                text = "Pribadi")
            ButtonQuest(
                onClick = { /*TODO*/ },
                text = "Publik")
        }
    }
}

@Preview
@Composable
fun TypesPlacePrev() {
    TypesPlacePage()
}