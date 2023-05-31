package com.example.travelyour.external.widget

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun TextTitle(
    text:String
) {
    Text(
        text = text,
    style = TextStyle(
        fontSize = 30.sp,
        fontWeight = FontWeight.SemiBold,
        color = Color.Black
    )
    )
}