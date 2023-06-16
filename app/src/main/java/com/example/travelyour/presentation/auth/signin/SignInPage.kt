package com.example.travelyour.presentation.auth.signin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable

import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.travelyour.Locator
import com.example.travelyour.R
import com.example.travelyour.external.widget.*
import com.example.travelyour.utils.ResultState

@Composable
fun SignInPage(navController: NavController) {
    val viewModel:SignInViewModel = viewModel(factory = Locator.signInViewModelFactory)
    val signInViewState by viewModel.signInViewState.collectAsState()

    LaunchedEffect(signInViewState.resultVerifyUser) {
        if (signInViewState.resultVerifyUser is ResultState.Success) {
            navController.navigate("home")
        }
    }


    Column(
       modifier = Modifier.padding(
           start = 16.dp,
           end = 16.dp,
           top = 50.dp),
       horizontalAlignment = Alignment.CenterHorizontally,
   ) {

       TextTitle(text = "Sign In")
       Spacer(modifier = Modifier.padding(top = 30.dp))
       EmailInput(

           labelValue = stringResource(id = R.string.email),
           painterResource(id = R.drawable.email),
           onValueChange = {viewModel.onEvent(SignInEvent.EmailChanged(it))},
           errorStatus = viewModel.loginUiState.value.emailError,
           placeholder = "Enter Your Email",
           )
            Spacer(modifier = Modifier.padding(top = 10.dp))
            PasswordInput(
            labelValue = stringResource(id = R.string.password),
                painterResource(id = R.drawable.lock),
           onPasswordChange = {viewModel.onEvent(SignInEvent.PasswordChanged(it))},
                errorStatus = viewModel.loginUiState.value.passwordError,
           placeholder = "Enter your password" ,
    )
       Spacer(modifier = Modifier.height(100.dp))
        ButtonPage(
            onClick = {viewModel.onEvent(SignInEvent.SignInButtonClicked) },
            isEnabled = viewModel.allValidationState.value,
            text = "Log In" )

       Spacer(modifier = Modifier.height(20.dp))
        ButtonBorderPage(

            onClick ={navController.navigate("sign_up")},
            text = "Register" )
       Spacer(modifier = Modifier.height(20.dp))
       if (viewModel.loginProgress.value){
           CircularProgressIndicator()
       }
       TextButtonCustome(
           onClick ={navController.navigate("forgot")} ,
           text = "Forgot Password ?")
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