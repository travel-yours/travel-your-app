package com.example.travelyour.presentation.homepage.artikel

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.travelyour.data.di.Injection
import com.example.travelyour.data.response.Artikel
import com.example.travelyour.external.widget.ArtikelItem
import com.example.travelyour.utils.ResultState

@Composable
fun ArtikelScreen(
    modifier: Modifier = Modifier,
    viewModel: ArtikelViewModel = viewModel(
        factory = ArtikelViewModel.Factory(Injection.provideRepository()),
    ),
 //   navigateToDetail: (Long) -> Unit

) {
    viewModel.resultState.collectAsState(initial = ResultState.Loading).value.let {
        resultState ->


        when(resultState){
            is ResultState.Loading -> {
                viewModel.getAllArtikel()
            }
            is ResultState.Success ->{
                resultState.data?.let {
                    ArtikelContent(
                        artikel = resultState.data,
                        navigateToDetail = {} )
                }
            }
            else -> {}
        }
    }

}


@Composable
fun ArtikelContent(
    artikel:List<Artikel>,
    modifier: Modifier = Modifier,
    navigateToDetail: (Long) -> Unit
){
 Column(){
     artikel.forEach{ data ->
         ArtikelItem(
             image = data.image ,
             title = data.title ,
             headTitle = data.headTitle,
             description = data.desc)
     }
 }


}