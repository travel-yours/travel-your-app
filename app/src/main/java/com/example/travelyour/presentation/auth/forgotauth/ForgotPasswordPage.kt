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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.travelyour.Locator
import com.example.travelyour.R
import com.example.travelyour.external.widget.ButtonPage
import com.example.travelyour.external.widget.EmailInput
import com.example.travelyour.external.widget.TextTitle
import com.example.travelyour.presentation.auth.signin.SignInEvent
import com.example.travelyour.presentation.auth.signin.SignInViewModel

@Composable
fun ForgotPasswordPage(navController: NavController) {
    val viewModel: SignInViewModel = viewModel(factory = Locator.signInViewModelFactory)
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

            labelValue = stringResource(id = R.string.email),
            painterResource(id = R.drawable.email),
            onValueChange = {viewModel.onEvent(SignInEvent.EmailChanged(it))},
            errorStatus = viewModel.loginUiState.value.emailError,
            placeholder = "Enter Your Email",
        )
        Spacer(modifier = Modifier.height(50.dp))
        ButtonPage(onClick = {navController.navigate("sign_in")}, text = "Confirmasi")
    }
}