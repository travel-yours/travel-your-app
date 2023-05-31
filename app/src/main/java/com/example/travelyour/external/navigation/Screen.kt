package com.example.travelyour.external.navigation

sealed class Screen (val route:String){
    object Splash: Screen("splash_screen")
    object StartHomeRoute: Screen(route = "start_home")
    object SignInPage: Screen(route = "sign_in")
    object SignUpPage: Screen(route = "sign_up")
    object ForgotPasswordPage: Screen(route = "forgot")
    object HomePage:Screen(route = "homepage")
}