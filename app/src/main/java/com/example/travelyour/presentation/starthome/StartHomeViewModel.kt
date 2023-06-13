package com.example.travelyour.presentation.starthome

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class StartHomeViewModel:ViewModel() {

    private val _alphaAnimation = MutableStateFlow(0f)
    val alphaAnimation: StateFlow<Float> = _alphaAnimation

    init {
        startAnimation()
    }

    private fun startAnimation() {
        viewModelScope.launch {
            while (true) {
                _alphaAnimation.value = 0f
                delay(500)
                _alphaAnimation.value = 1f
                delay(500)
            }
        }
    }
}