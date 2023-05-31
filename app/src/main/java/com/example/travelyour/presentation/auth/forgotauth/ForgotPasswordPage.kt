package com.example.travelyour.presentation.auth.forgotauth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.travelyour.external.widget.ButtonPage
import com.example.travelyour.external.widget.EmailInput
import com.example.travelyour.external.widget.TextTitle

@Composable
fun ForgotPasswordPage(navController: NavController) {
    var email by remember {
        mutableStateOf("")
    }
    Column(modifier = Modifier
        .padding(
            start = 16.dp,
            end = 16.dp,
            top = 50.dp,
        ),
    horizontalAlignment = Alignment.CenterHorizontally) {
        TextTitle(text = "Verfikasi")
        Spacer(modifier = Modifier.height(150.dp))
        EmailInput(
            value = email ,
            onValueChange = {email = it},
            placeholder = "Enter Your Email" ,
            errorMessage = "Email cannot be empty" )
        Spacer(modifier = Modifier.height(50.dp))
        ButtonPage(onClick = {navController.navigate("sign_in")}, text = "Confirmasi")
    }
}