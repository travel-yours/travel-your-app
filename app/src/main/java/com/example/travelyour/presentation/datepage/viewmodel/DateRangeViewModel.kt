package com.example.travelyour.presentation.datepage.viewmodel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.time.LocalDate

class DateRangeViewModel : ViewModel() {


   private val _startDate = MutableLiveData(LocalDate.now())
    private val _endDate = MutableLiveData(LocalDate.now())

    val startDate: LiveData<LocalDate> get() = _startDate
    val endDate: LiveData<LocalDate> get() = _endDate



    fun setStartDate(date: LocalDate){
        _startDate.value = date
    }

    fun setEndDate(date: LocalDate){
        _endDate.value = date
    }
}