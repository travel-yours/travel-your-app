package com.example.travelyour.presentation.homepage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.travelyour.data.repository.ArtikelRepository
import com.example.travelyour.data.response.Artikel
import com.example.travelyour.utils.ResultState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: ArtikelRepository
): ViewModel() {
    private val _resultState: MutableStateFlow<ResultState<List<Artikel>>> = MutableStateFlow(ResultState.Loading)
    val resultState:StateFlow<ResultState<List<Artikel>>>
    get() = _resultState

    fun getAllArtikel(){
        viewModelScope.launch {
            repository.getAllArtikel()
                .catch {
                    _resultState.value = ResultState.Error(it.message.toString())
                }
                .collect{artikel ->
                    _resultState.value = ResultState.Success(artikel)
                }
        }
    }
}