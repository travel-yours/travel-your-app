package com.example.travelyour.presentation.auth.signup



import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.travelyour.external.widget.*

@Composable
fun SignUpPage(navController: NavController) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember{ mutableStateOf("") }
    Column(
        modifier = Modifier.padding(
            start = 16.dp,
            end = 16.dp,
            top = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        TextTitle(text = "Sign Up")
        Spacer(modifier = Modifier.padding(top = 30.dp))
        NameInput(
            value = name,
        onValuChange = {name = it},
        placeholder = "Enter Your Name",
        errorMessage = "Name cannot be empty")
        Spacer(modifier = Modifier.height(10.dp))
        EmailInput(

            value = email ,
            onValueChange = {email = it},
            placeholder = "Enter Your Email",
            errorMessage = "Email cannot be empty")
        Spacer(modifier = Modifier.padding(top = 10.dp))
        PasswordInput(
            value = password,
            onPasswordChange = {password = it},
            placeholder = "Enter your password" ,
            errorMessage = "Password cannot be empty")
        Spacer(modifier = Modifier.height(100.dp))
        ButtonBorderPage(
            onClick = {},
            text = "Register" )
        Spacer(modifier = Modifier.height(20.dp))
        TextButtonCustome(
            onClick ={navController.navigate("sign_in")} ,
            text = "Are you have account ?")
    }
}





@Preview
@Composable
fun SignInPrev() {
    Surface(modifier = Modifier
        .fillMaxSize()
        .background(Color.Gray)
        .padding(start = 10.dp, end = 10.dp)) {


    }
}