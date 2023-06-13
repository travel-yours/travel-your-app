package com.example.travelyour.presentation.feature_timeline.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.travelyour.data.response.Artikel
import com.example.travelyour.external.widget.DestinationItem
import com.example.travelyour.external.widget.SearchBarCustom
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.travelyour.data.di.Injection
import com.example.travelyour.external.widget.TextTitle
import com.example.travelyour.utils.ResultState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTimeLineSCreen() {
    var search by remember { mutableStateOf("") }
  Column(
      modifier = Modifier
          .padding(start = 16.dp, end = 16.dp, top = 30.dp)
          .fillMaxSize()
  ){
       TextTitle(text = "Ayo buat rencana\nperjalanan anda")

        Spacer(modifier = Modifier.height(8.dp))
        SearchBarCustom(value = search, onValueChange ={search = it} )
        Spacer(modifier = Modifier.height(16.dp))
        HomeTimeline()
  }
}

@Composable
fun HomeTimeline(
    modifier: Modifier = Modifier,
    viewModel: HomeTimelineViewModel = viewModel(
        factory = HomeTimelineViewModel.Factory(Injection.provideRepository())
    )
) {
    val resultState by viewModel.resultState.collectAsState(initial = ResultState.Loading)

    LaunchedEffect(key1 = resultState) {
        if (resultState is ResultState.Loading) {
            viewModel.getAllDestinationl()
        }
    }
    when (resultState) {
        is ResultState.Success -> {
            resultState.data?.let { destinations ->
              HomeContent(navigateToDetail = {}, destination = destinations)
            }
        }
        else -> {}
    }
    }



@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    navigateToDetail: (Long) -> Unit,
    destination:List<Artikel>
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(160.dp) ,
      //  contentPadding = PaddingValues(10.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
    ) {

        items(destination){data ->
       DestinationItem(image = data.image, title = data.title)
        }
    }
}