package com.example.travelyour.external.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.travelyour.presentation.auth.forgotauth.ForgotPasswordPage
import com.example.travelyour.presentation.auth.signin.SignInPage
import com.example.travelyour.presentation.auth.signup.SignUpPage
import com.example.travelyour.presentation.auth.signup.SignUpViewModel
import com.example.travelyour.presentation.camera.CameraActivity
import com.example.travelyour.presentation.feature_timeline.home.HomeTimeLineSCreen
import com.example.travelyour.presentation.homepage.HomePage
import com.example.travelyour.presentation.quesionerpage.CategoryPage
import com.example.travelyour.presentation.splash.SplashScreen
import com.example.travelyour.presentation.starthome.StartHome

@Composable
fun SetupNavGraph(navController: NavHostController,modifier: Modifier) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ){
       composable(route = Screen.Splash.route){
           SplashScreen(navHostController = navController)
       }
        composable(route = Screen.StartHomeRoute.route){
            StartHome(navController)
        }
        composable(route = Screen.SignInPage.route){
            SignInPage(navController)
        }
        composable(route = Screen.SignUpPage.route){
            SignUpPage(navController)
        }
        composable(route = Screen.ForgotPasswordPage.route){
            ForgotPasswordPage(navController)
        }
        composable(route =Screen.Home.route){
            HomePage()
        }
        composable(route =Screen.Timeline.route){
            CategoryPage()
        }
        composable(route = Screen.Camera.route){

        }
        composable(route = Screen.HomeTimeline.route){
            HomeTimeLineSCreen()
        }
    }

}