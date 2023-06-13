package com.example.travelyour.presentation.splash

import com.example.travelyour.utils.ResultState

data class SplashViewState(
    val resultIsLoggedIn: ResultState<Boolean> = ResultState.Idle()
)
