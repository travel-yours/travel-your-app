package com.example.travelyour.presentation.splash


import android.annotation.SuppressLint
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.travelyour.Locator
import com.example.travelyour.external.navigation.Screen
import com.example.travelyour.utils.ResultState
import kotlinx.coroutines.delay

@SuppressLint("SuspiciousIndentation")
@Composable
fun SplashScreen(
    navHostController: NavHostController,

) {

    val viewModel:SplashViewModel = viewModel(factory = Locator.splashViewModelFactory)
    val alphaAnimation by viewModel.alphaAnimation.collectAsState()

    LaunchedEffect(key1 = true, ){
        viewModel.startAnimation()
        delay(3000)
        val isLoggedResult = viewModel.splashViewState.value.resultIsLoggedIn
        val isLoggedIn = isLoggedResult is ResultState.Success && isLoggedResult.data!!
        if (isLoggedIn){
            navHostController.navigate(Screen.Home.route)
        }else{
            navHostController.popBackStack()
            navHostController.navigate(Screen.StartHomeRoute.route)
        }

    }
    SplashView(alpha = alphaAnimation)
}



    @Composable
    @Preview
    fun SplashPrev() {
        val navHostController = rememberNavController()

    SplashScreen(
        navHostController = navHostController,
    )
    }