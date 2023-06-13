package com.example.travelyour.external.widget



import androidx.compose.foundation.layout.*
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun CircularProgressBar(
    isDisplayed:Boolean,
) {
    if (isDisplayed){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(50.dp)
        ) {
            LinearProgressIndicator()
        }
    }
}
