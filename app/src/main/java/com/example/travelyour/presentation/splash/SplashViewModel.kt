package com.example.travelyour.presentation.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.travelyour.domain.usecase.GetUserUseCase
import com.example.travelyour.domain.usecase.SignUpUseCase
import com.example.travelyour.presentation.auth.signup.SignUpViewModel
import com.example.travelyour.utils.ResultState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SplashViewModel(
    private val getUserUseCase: GetUserUseCase
):ViewModel() {
    private val _alphaAnimation = MutableStateFlow(0F)
    val alphaAnimation : StateFlow<Float> = _alphaAnimation
    private val _splashViewState = MutableStateFlow(SplashViewState())
    val splashViewState = _splashViewState.asStateFlow()

    init {
        getIsLoggedIn()
    }

    fun startAnimation(){
        viewModelScope.launch {
            val animationDuration = 2000
            val startTime = System.currentTimeMillis()
            while (System.currentTimeMillis() - startTime < animationDuration){
                val progress = (System.currentTimeMillis() - startTime) / animationDuration.toFloat()
                _alphaAnimation.value = progress
                delay(15)
            }
            _alphaAnimation.value = 1f
        }
    }
    private fun getIsLoggedIn() {
        viewModelScope.launch {
            getUserUseCase().collect { user ->
                delay(3000)
                _splashViewState.update {
                    it.copy(resultIsLoggedIn = ResultState.Success(user.token.isNotEmpty()))
                }
            }
        }
    }

    class Factory(
        private val getUserUseCase : GetUserUseCase
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHEKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(SplashViewModel::class.java)) {
                return SplashViewModel(getUserUseCase) as T
            }
            error("Unknown ViewModel class: $modelClass")
        }
    }

}