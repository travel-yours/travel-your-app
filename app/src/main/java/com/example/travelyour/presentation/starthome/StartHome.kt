package com.example.travelyour.presentation.starthome

import android.annotation.SuppressLint
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*


import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview


import androidx.compose.ui.unit.*
import androidx.navigation.NavController

import com.example.travelyour.R

import com.example.travelyour.external.theme.secondary
import com.example.travelyour.external.theme.secondaryPrimay


@Composable
fun StartHome(navController: NavController) {
     val infiniteTransition = rememberInfiniteTransition()
      val alpha by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 2000
                0.5f at 500
                1f at 1000
            },
            repeatMode = RepeatMode.Restart

        )
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .background(
                Brush.linearGradient(
                    colors = listOf(secondary, secondaryPrimay),
                    start = Offset.Zero,
                    end = Offset.Infinite
                )
            )

    ) {
        Image(
            painter = painterResource(R.drawable.union),
            contentDescription = "Peta Nusantara",
            modifier = Modifier.fillMaxSize(),
            alignment = Alignment.TopCenter
        )
        Column(
            modifier = Modifier
                .padding(20.dp)
                .align(Alignment.TopStart)
                .fillMaxWidth(),

            horizontalAlignment = Alignment.Start


        ) {

            PinImage(
            imageId = R.drawable.loc1,
            contentDescription = "Pin Loc" ,
            modifier = Modifier
                .padding(top = 30.dp, bottom = 80.dp)
                .size(50.dp)
                .fillMaxWidth()
                .alpha(alpha))
           Spacer(modifier = Modifier.height(80.dp))

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                PinImage(
                    imageId = R.drawable.loc2,
                    contentDescription = "Pin Loc" ,
                    modifier = Modifier
                        .size(100.dp)
                        .alpha(alpha))
                PinImage(
                    imageId = R.drawable.loc3,
                    contentDescription = "Pin Loc" ,
                    modifier = Modifier
                        .size(60.dp)
                        .alpha(alpha))

            }
            Spacer(modifier = Modifier.padding( top = 30.dp))
            PinImage(
                imageId = R.drawable.loc1,
                contentDescription = "Pin Loc" ,
                modifier = Modifier
                    .padding(top = 30.dp, start = 150.dp)
                    .size(65.dp)
                    .fillMaxWidth()

            )
            Spacer(modifier = Modifier.height(100.dp))

         Text(text = "Free Your Self",
         style = TextStyle(
             fontWeight = FontWeight.Bold,
             color = Color.White,
             fontSize = 30.sp
         )
         )
            Text(text = "Explore amazing place around  the globe",
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    color = Color.White,
                    fontSize = 16.sp
                ),
                modifier = Modifier.padding( bottom = 50.dp)
            )


            RoundedButton(
                modifier = Modifier.padding(bottom = 30.dp),
                onClick =  {navController.navigate("sign_in")},
                text = "Lets Go",
            )
        }
    }
}


@Composable
fun RoundedButton(
    onClick:() -> Unit,
    text:String,
 modifier: Modifier = Modifier

) {
  Button(onClick = onClick,
  modifier = modifier

      .fillMaxWidth()
      .height(60.dp),
  shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp, bottomEnd = 10.dp, bottomStart = 10.dp),
      colors = ButtonDefaults.buttonColors(containerColor = Color.White, contentColor = Color.Blue)
  ) {
Text(text = text)
  }
}

@SuppressLint("SuspiciousIndentation")
@Composable
fun PinImage(
    imageId: Int,
    contentDescription: String?,
    modifier: Modifier = Modifier
) {
  val painter: Painter = painterResource(id = imageId)
     Image(
         painter = painter ,
         contentDescription = contentDescription,
         modifier = modifier)
}
@Preview
@Composable
fun StartHomePrev() {


}