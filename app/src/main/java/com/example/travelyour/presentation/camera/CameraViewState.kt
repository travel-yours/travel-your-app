package com.example.travelyour.presentation.camera

import com.example.travelyour.data.response.DestinationResponse
import com.example.travelyour.data.response.MlResponse
import com.example.travelyour.utils.ResultState

data class CameraViewState(
    val resultImageDetection:ResultState<DestinationResponse> = ResultState.Idle
)
