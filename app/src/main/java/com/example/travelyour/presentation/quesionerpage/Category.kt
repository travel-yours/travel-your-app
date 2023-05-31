package com.example.travelyour.presentation.quesionerpage

import BackgroundPage
import androidx.compose.foundation.layout.Arrangement
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
fun CategoryPage() {
    BackgroundPage(
        icon = {
            CircleButton(
                onClick = { /*TODO*/ },
                size = 50.dp,
            backgroundColor = primary2,
            blurRadius = 30.dp)
        }) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextTitle(text = "Kategori")
            TextHeadline(text = "Pilih Kategori Wisata")
            ButtonQuest(
                onClick = { /*TODO*/ },
                text = "Keluarga")
            ButtonQuest(
                onClick = { /*TODO*/ },
                text ="Pasangan" )
            ButtonQuest(
                onClick = { /*TODO*/ },
                text = "Jomblo")
        }

    }
}

@Preview
@Composable
fun CategoryPrev() {
    CategoryPage()
    
}