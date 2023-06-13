package com.example.travelyour.presentation.auth.signup



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
import com.example.travelyour.presentation.auth.signin.SignInEvent
import com.example.travelyour.utils.ResultState


@Composable
fun SignUpPage(navController: NavController) {
    val viewModel: SignUpViewModel = viewModel(factory = Locator.signUpViewModelFactory)
    val signUpViewState by viewModel.signUpViewState.collectAsState()

    LaunchedEffect(signUpViewState.resultVerifyUser) {
        if (signUpViewState.resultVerifyUser is ResultState.Success) {
            navController.navigate("sign_in")
        }
    }
    Column(
        modifier = Modifier.padding(
            start = 16.dp,
            end = 16.dp,
            top = 50.dp
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        TextTitle(text = "Sign Up")
        Spacer(modifier = Modifier.padding(top = 30.dp))
        NameInput(
            labelValue = stringResource(id = R.string.name),
            painterResource(id = R.drawable.person),
            onValueChange = {viewModel.onEvent(SignUpEvent.NameChanged(it))},
            errorStatus = viewModel.registrationUiState.value.nameError,
            placeholder = "Enter Your Name",
        )
        Spacer(modifier = Modifier.height(10.dp))
        EmailInput(

            labelValue = stringResource(id = R.string.email),
            painterResource(id = R.drawable.email),
            onValueChange = {viewModel.onEvent(SignUpEvent.EmailChanged(it))},
            errorStatus = viewModel.registrationUiState.value.emailError,
            placeholder = "Enter Your Email",
        )
        Spacer(modifier = Modifier.padding(top = 10.dp))
        PasswordInput(
            labelValue = stringResource(id = R.string.password),
            painterResource(id = R.drawable.lock),
            onPasswordChange = {viewModel.onEvent(SignUpEvent.PasswordChanged(it))},
            errorStatus = viewModel.registrationUiState.value.passwordError,
            placeholder = "Enter your password" ,
        )
        Spacer(modifier = Modifier.height(100.dp))

        ButtonPage(
            onClick = {
                viewModel.onEvent(SignUpEvent.RegisterButton)
                      navController.navigate("sign_in")},
            isEnabled = viewModel.allValidationsPassed.value,
            text = "Register" )
        Spacer(modifier = Modifier.height(20.dp))

        if (viewModel.signUpProgress.value){
            CircularProgressIndicator()
        }
        TextButtonCustome(
            onClick = { navController.navigate("sign_in") },
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


//   LaunchedEffect(Unit){
//        signUpViewState.resultSignUpUser?.let {result ->
//            when(result){
//                is  ResultState.Success ->{
//                    navController.navigate("sign_in")
//                }
//                is ResultState.Error ->{
//
//                }
//                else -> Unit
//            }
//        }
//    }