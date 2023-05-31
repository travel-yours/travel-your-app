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
fun OptionsPlacePage() {
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
            TextTitle(text = "Pilihan Tempat")
            TextHeadline(text = "Apakah anda tipe orang yang suka tempat\n populer atau tersembunyi")
            ButtonQuest(
                onClick = { /*TODO*/ },
                text = "Populer")
            ButtonQuest(
                onClick = { /*TODO*/ },
                text = "Hidden Gym")
            ButtonQuest(
                onClick = { /*TODO*/ },
                text = "New Arrival")
        }
    }
}

@Preview
@Composable
fun OptionsPlacePrev() {
    OptionsPlacePage()
}