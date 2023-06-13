package com.example.travelyour.external.widget

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.travelyour.external.theme.gray

@ExperimentalMaterial3Api
@Composable
fun SearchBarCustom(
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
        singleLine = true,
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