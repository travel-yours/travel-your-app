package com.example.travelyour.external.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen (val route:String){
    object Splash: Screen("splash_screen")
    object StartHomeRoute: Screen(route = "start_home")
    object SignInPage: Screen(route = "sign_in")
    object SignUpPage: Screen(route = "sign_up")
    object ForgotPasswordPage: Screen(route = "forgot")
    object Home:Screen(route = "home")
    object Timeline:Screen(route = "timeline")
    object Camera:Screen(route = "camera")
    object HomeTimeline:Screen(route = "hometimeline")

}
