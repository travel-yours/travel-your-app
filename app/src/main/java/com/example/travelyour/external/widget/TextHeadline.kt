package com.example.travelyour.external.widget

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun TextHeadline(
    text: String
) {
    Text(text = text,
    fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        color = Color.Black,
        maxLines = 2,
        textAlign = TextAlign.Center
    )
}