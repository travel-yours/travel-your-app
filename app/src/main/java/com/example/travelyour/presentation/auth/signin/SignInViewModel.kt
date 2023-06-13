package com.example.travelyour.presentation.auth.signin

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.travelyour.domain.contract.SignInUseCaseContract
import com.example.travelyour.domain.usecase.SignInUseCase
import com.example.travelyour.external.navigation.Screen
import com.example.travelyour.utils.TextFieldState
import com.example.travelyour.utils.Validator
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class SignInViewModel(
    private val signInUseCase: SignInUseCaseContract
):ViewModel() {

    private val _signInState = MutableStateFlow(SignInViewState())
    val signInViewState = _signInState.asStateFlow()
    private lateinit var navController: NavController
     var loginUiState = mutableStateOf(SignInViewState())
     var allValidationState = mutableStateOf(false)
     var loginProgress = mutableStateOf(false)


    fun onEvent(event: SignInEvent){
        when(event){
            is SignInEvent.EmailChanged -> {
                loginUiState.value = loginUiState.value.copy(
                    email = event.email
                )
            }
            is SignInEvent.PasswordChanged -> {
                loginUiState.value = loginUiState.value.copy(
                    password = event.password
                )
            }
            is SignInEvent.SignInButtonClicked -> {
                doSignIn(

                )
            }
        }
        validateLogin()
    }

    private fun validateLogin(){
        val emailResult = Validator.validateEmail(
            email = loginUiState.value.email
        )
        val passwordResult = Validator.validatePassword(
            password = loginUiState.value.password
        )
        loginUiState.value = loginUiState.value.copy(
            emailError = emailResult.status,
            passwordError = passwordResult.status
        )
        allValidationState.value = emailResult.status && passwordResult.status
    }

    fun doSignIn(
    ){
        loginProgress.value = true
        val email = loginUiState.value.email
        val password = loginUiState.value.password
        signInUseCase(email, password)
            .onEach { result ->
                _signInState.update {
                    it.copy(resultVerifyUser = result)
                }
            if (result.isSuccess){
                loginProgress.value = false
            }
            }.launchIn(viewModelScope)
    }

    class Factory(
        private val signInUseCase: SignInUseCase
    ):ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(SignInViewModel::class.java)) {
                return SignInViewModel(signInUseCase) as T
            }
            error("Unknown ViewModel class: $modelClass")
        }

    }
    }


