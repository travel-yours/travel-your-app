package com.example.travelyour.presentation.homepage


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.travelyour.data.source.local.DataProvide
import com.example.travelyour.external.theme.gray
import com.example.travelyour.external.widget.TextTitle
import com.example.travelyour.model.ArikelList
import com.example.travelyour.model.Menu
import com.example.travelyour.model.dummyMenu

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage() {
    var search by remember { mutableStateOf("") }
    val artikels = remember { DataProvide.articelList }

    LazyColumn(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 30.dp)
            .fillMaxSize()
    ) {
        item {
            TopBar()
            TextTitle(text = "Jelajahi harimu\nBersama Travel your")
            Spacer(modifier = Modifier.padding(bottom = 10.dp))
            SearchBar(
                value = search,
                onValueChange = { search = it }
            )
        }

        item {
            HomePageSection(content = { MenuItemRow(dummyMenu) })
        }


        items(
            items = artikels,
            itemContent = {
                ArtikelListItem(arikelList = it)
            }
        )
    }
}


@Composable
fun HomePageSection(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(modifier) {
        content()
    }
}


@ExperimentalMaterial3Api
@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    value:String,
    onValueChange:(String) -> Unit
) {
    TextField(
        value = value ,
        onValueChange = onValueChange,
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription =  null )
        },
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = gray,
            disabledIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        placeholder = {
            Text(text = "Search")
        },
        modifier = modifier
            .padding(bottom = 20.dp)
            .fillMaxWidth()
            .heightIn(min = 40.dp)
            .clip(RoundedCornerShape(16.dp))
    )

}

@Composable
fun MenuItem(
    menu: Menu,
    modifier: Modifier = Modifier,
) {
        Card(
            modifier = modifier.width(250.dp),
            shape = RoundedCornerShape(10.dp)
        ) {
          Box{
              Image(
                  painter = painterResource(menu.image),
                  contentDescription = null,
                  contentScale = ContentScale.Crop,
                  modifier = Modifier

                      .fillMaxWidth()
                      .height(300.dp)

                      .clip(RoundedCornerShape(8.dp)),

                  )

               Text(
                   text = menu.title,
                   overflow = TextOverflow.Ellipsis,
                   style = TextStyle(
                       fontSize = 16.sp,
                       fontWeight = FontWeight.SemiBold,
                       color = Color.White,
                       ),

                   modifier = Modifier
                       .align(Alignment.BottomStart)
                       .padding(start = 10.dp, bottom = 20.dp),




               )
           


          }

        }
    }


@Composable
fun MenuItemRow(
    listMenu: List<Menu>,
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    contentPadding = PaddingValues(horizontal = 10.dp),
        modifier = modifier
        ){
        items(listMenu, key = {it.title}){ menu ->
            MenuItem(menu)
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
   TopAppBar(
       title = {
          Text(text = "Mizanul Anoha",
          style = TextStyle(
              fontSize = 16.sp,
              fontWeight = FontWeight.SemiBold,
              color = Color.Gray
          )
          )
       },
       actions = {
           IconButton(onClick = {}) {
               Icon(Icons.Filled.Menu, contentDescription = "Menu")
           }
       }
   )

}

@Composable
fun ArtikelListItem(arikelList: ArikelList) {
    Card(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth(),

    ) {
        Row() {
            ArtikelImage(arikelList)
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.Top)
            ) {
                Text(text = arikelList.title, style = typography.titleSmall)
                Text(text = arikelList.headline, style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                ))
                Text(text = arikelList.desc, style = TextStyle(
                    fontSize = 16.sp
                ),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }

        }
    }

}

@Composable
fun ArtikelImage(arikelList: ArikelList) {
    Image(
        painter = painterResource(id = arikelList.imageId),
        contentDescription = null,
    contentScale = ContentScale.Crop,
    modifier = Modifier
        .padding(8.dp)
        .size(85.dp)
        .clip(RoundedCornerShape(corner = CornerSize(16.dp))))

}

@Preview
@Composable
fun PrevImage() {
    val artikel = DataProvide.articel


}





