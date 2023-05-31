package com.example.travelyour.presentation.quesionerpage

import BackgroundPage
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.travelyour.external.theme.primary2
import com.example.travelyour.external.widget.*

@Composable
fun OptionsCostPage() {
 BackgroundPage(
     icon = {
     CircleButton(
         onClick = { /*TODO*/ },
         size =  50.dp,
         backgroundColor = primary2,
         blurRadius = 30.dp)}) {
     Column(
         horizontalAlignment = Alignment.CenterHorizontally,
         verticalArrangement = Arrangement.Top
     ) {
         TextTitle(text = "Pilih Biaya Wisata")
         TextHeadline(text = "Pilih prefensi untuk biaya\ntempat wisata")
         ButtonQuest(onClick = { /*TODO*/ }, text ="Ekonomis" )
         ButtonQuest(onClick = { /*TODO*/ }, text = "Normal")
         ButtonQuest(onClick = { /*TODO*/ }, text = "Bisnis")
     }
     
 }
}

@Preview
@Composable
fun OptionsCostPrev() {
    OptionsCostPage()
}