package com.example.travelyour.external.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.travelyour.R
import com.example.travelyour.external.theme.primary

@Composable
fun DestinationItem(
    image:Int,
    title:String
) {
    Box(
        Modifier.clip(RoundedCornerShape(10.dp))
    ) {
        Image(painter = painterResource(image),
            contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            .size(150.dp)
            .clip(RoundedCornerShape(8.dp)))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .size(30.dp)
                .background(primary)
                .clip(RoundedCornerShape(topEnd = 10.dp, bottomEnd = 50.dp))
                .align(Alignment.BottomStart)
        ) {

            Text(
                text = title,
                overflow = TextOverflow.Ellipsis,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White,
                ),

                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(start = 10.dp, bottom = 5.dp, top = 5.dp),




                )
        }
    }
}

@Preview
@Composable
fun DestinationPrev() {
    DestinationItem(image = R.drawable.gunung, title = "gunung")

}