package com.example.travelyour.presentation.auth.signup

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.travelyour.domain.contract.SignUpUseCaseContract
import com.example.travelyour.domain.usecase.SignUpUseCase
import com.example.travelyour.external.navigation.Screen
import com.example.travelyour.utils.Validator
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class SignUpViewModel(
    private val signUpUseCase: SignUpUseCaseContract,

): ViewModel(){
    private val _signUpViewState = MutableStateFlow(SignUpViewState())

    val signUpViewState = _signUpViewState.asStateFlow()
    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading
    lateinit var navController: NavController
    var registrationUiState = mutableStateOf(SignUpViewState())
    var allValidationsPassed = mutableStateOf(false)
    var signUpProgress = mutableStateOf(false)

    fun onEvent(event:SignUpEvent){
        when(event){
            is SignUpEvent.NameChanged -> {
                registrationUiState.value = registrationUiState.value.copy(
                    name = event.name
                )

            }
            is SignUpEvent.EmailChanged -> {
                registrationUiState.value = registrationUiState.value.copy(
                    email = event.email
                )
            }
            is SignUpEvent.PasswordChanged -> {
                registrationUiState.value = registrationUiState.value.copy(
                    password = event.password
                )
            }
            is SignUpEvent.RegisterButton -> {
                signUpUser()
            }
        }
        validateDataRegistration()
    }

    private fun validateDataRegistration(){
        val nameResult = Validator.validateFirstNma(
            name = registrationUiState.value.name
        )

        val emailResult = Validator.validateEmail(
            email = registrationUiState.value.email
        )
        val passwordResult = Validator.validatePassword(
            password = registrationUiState.value.password
        )

        Log.d(TAG, "validationRegistration")
        Log.d(TAG,"nameResult = $nameResult")
        Log.d(TAG,"emailResult = $emailResult")
        Log.d(TAG, "passwordResult = $passwordResult")

        registrationUiState.value = registrationUiState.value.copy(
            nameError = nameResult.status,
            emailError =  emailResult.status,
            passwordError = passwordResult.status
        )

        allValidationsPassed.value = nameResult.status && emailResult.status && passwordResult.status
    }
    private fun printState(){
        Log.d(TAG,"printState")
        Log.d(TAG, registrationUiState.value.toString())
    }
    fun signUpUser() {
        signUpProgress.value = true
        val name = registrationUiState.value.name
        val email = registrationUiState.value.email
        val password = registrationUiState.value.password
        signUpUseCase(name, email, password)
                .onEach { result ->
                    _signUpViewState.update {
                        it.copy(resultVerifyUser = result)
                    }
                    if (result.isSuccess) {
                        signUpProgress.value = false
                    }
                }.launchIn(viewModelScope)

    }


          class Factory(
              private val signUpUseCase: SignUpUseCase
          ) : ViewModelProvider.Factory {
              @Suppress("UNCHEKED_CAST")
              override fun <T : ViewModel> create(modelClass: Class<T>): T {
                  if (modelClass.isAssignableFrom(SignUpViewModel::class.java)) {
                      return SignUpViewModel(signUpUseCase) as T
                  }
                  error("Unknown ViewModel class: $modelClass")
              }
          }
}


//  private val _navController = mutableStateOf<NavController?>(null)
//    val navController: State<NavController?> = _navController
//
//    fun setNavController(navController: NavController){
//        _navController.value = navController
//    }