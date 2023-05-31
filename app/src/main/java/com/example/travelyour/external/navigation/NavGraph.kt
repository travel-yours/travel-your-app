package com.example.travelyour.external.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.travelyour.presentation.auth.forgotauth.ForgotPasswordPage
import com.example.travelyour.presentation.auth.signin.SignInPage
import com.example.travelyour.presentation.auth.signup.SignUpPage
import com.example.travelyour.presentation.homepage.HomePage
import com.example.travelyour.presentation.splash.SplashScreen
import com.example.travelyour.presentation.starthome.StartHome

@Composable
fun SetupNavGraph(navController: NavHostController) {
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
        composable(route = Screen.HomePage.route){
            HomePage()
        }
    }

}