package com.example.travelyour.presentation.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.travelyour.R
import com.example.travelyour.external.theme.primary

@Composable
fun SplashView(alpha:Float) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(primary),
    contentAlignment = Alignment.Center){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = painterResource(id = R.drawable.logo_travel),
                contentDescription = "Logo Travel Yours",
            modifier = Modifier.fillMaxWidth())

            Text(
                text = "Travel Yours",
                style = TextStyle(
                    fontSize = 20.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier
                    .padding(top = 18.dp)
            )

        }
    }
}