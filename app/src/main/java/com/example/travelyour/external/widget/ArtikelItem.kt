package com.example.travelyour.external.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ArtikelItem(
    image:Int,
    title:String,
    headTitle:String,
    description:String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth(),

        ) {
        Row() {
            Image(
                painter = painterResource(image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(8.dp)
                    .size(85.dp)
                    .clip(RoundedCornerShape(corner = CornerSize(16.dp))))
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.Top)
            ) {
                Text(text = title, style = MaterialTheme.typography.titleSmall)
                Text(text = headTitle, style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                )
                Text(text = description, style = TextStyle(
                    fontSize = 16.sp
                ),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }

        }
    }

}