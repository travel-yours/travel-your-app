package com.example.travelyour.presentation.camera

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.travelyour.data.response.DestinationResponse
import com.example.travelyour.domain.contract.ImageDetectionUseCaseContract
import com.example.travelyour.domain.usecase.ImageDetectionUseCase
import com.example.travelyour.utils.ResultState
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.io.File


class CameraViewModel(private val imageDetectionUseCase: ImageDetectionUseCaseContract) : ViewModel() {
    private val _imageDetectionState = MutableStateFlow<ResultState<DestinationResponse>>(ResultState.Idle)
    val imageDetectionState: StateFlow<ResultState<DestinationResponse>> = _imageDetectionState

    fun imageDetection(
        file: File,
        name: String,
        description: String,
        location: String,
        price: Int,
        facilities: String,
        imageUrl: String
    ) {
        viewModelScope.launch {
            _imageDetectionState.value = ResultState.Loading
            try {
                val responseFlow = imageDetectionUseCase(file, name, description, location, price, facilities, imageUrl)
                responseFlow.collect { result ->
                    _imageDetectionState.value = result
                }
            } catch (e: Exception) {
                _imageDetectionState.value = ResultState.Error(e.message.toString())
            }
        }
    }





    class Factory(
        private val imageDetectionUseCase: ImageDetectionUseCase
    ):ViewModelProvider.Factory{
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(CameraViewModel::class.java)){
                return CameraViewModel(imageDetectionUseCase) as T
            }
            error("Unknown viewModel class: $modelClass")
        }
    }
}