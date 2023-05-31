package com.example.travelyour.presentation.splash

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.travelyour.R
import com.example.travelyour.external.navigation.Screen
import com.example.travelyour.external.theme.primary
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navHostController: NavHostController
) {
var startAnimation by remember { mutableStateOf(false) }
    val alphaAnimation = animateFloatAsState(targetValue = if (startAnimation) 1f else 0f,
    animationSpec = tween(durationMillis = 3000)
    )
    LaunchedEffect(key1 = true ){
        startAnimation = true
        delay(3000)
        navHostController.popBackStack()
        navHostController.navigate(Screen.StartHomeRoute.route)
    }
   SplashView(alfa = alphaAnimation.value)
}


@Composable
fun SplashView(alfa:Float) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(primary),
        contentAlignment = Alignment.Center
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = painterResource(R.drawable.logo_travel),
                contentDescription = "Logo Travel Yours",
                modifier = Modifier
                    .fillMaxWidth()

            )
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

    @Composable
    @Preview
    fun SplashPrev() {
    SplashView(alfa = 1f)
    }