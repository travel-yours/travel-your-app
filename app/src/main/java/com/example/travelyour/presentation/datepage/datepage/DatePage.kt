package com.example.travelyour.presentation.datepage.datepage

import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import com.example.travelyour.external.widget.ComposeDatePicker
import com.example.travelyour.presentation.datepage.viewmodel.DateRangeViewModel
import java.time.LocalDate

@Composable
fun DatePage(viewModel: DateRangeViewModel) {
    val startDate by viewModel.startDate.observeAsState()
    val endDate by viewModel.endDate.observeAsState()

    ComposeDatePicker(
        startDate = startDate ?: LocalDate.now(),
        endDate = endDate ?: LocalDate.now(),
        onStartDateSelected = {selectedDate ->
            viewModel.setStartDate(selectedDate)
        },
        onEndDateSelected = {selectedDate ->
            viewModel.setEndDate(selectedDate)
        })
}