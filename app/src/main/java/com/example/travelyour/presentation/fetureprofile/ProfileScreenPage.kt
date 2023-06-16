package com.example.travelyour.presentation.fetureprofile

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.travelyour.R

@Composable
fun ProfileScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(modifier = Modifier

                .weight(1f)
                .fillMaxWidth()) {
                Image(
                    painter = painterResource(R.drawable.stay),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier.fillMaxWidth()
                )
                Box(modifier = Modifier
                    .padding(top = 200.dp)
                    .align(Alignment.TopCenter)
                    ){
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    val profileImage = painterResource(id = R.drawable.gunung) // Ganti dengan sumber daya gambar profil Anda
                    ProfilePicture(
                        modifier = Modifier.size(150.dp).clip(shape = RectangleShape),
                        painter = profileImage,
                        contentDescription = "Profile Picture"
                    )
                    Text(
                        text = "Travel Yours", // Ganti dengan nama Anda
                        style = MaterialTheme.typography.headlineMedium,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "123 Main Street, City", // Ganti dengan alamat Anda
                        style = MaterialTheme.typography.labelSmall,
                        textAlign = TextAlign.Center
                    )
                    
                }
                }


            }

        }
    }
}

@Composable
fun ProfilePicture(
    modifier: Modifier = Modifier,
    painter: Painter,
    contentDescription: String?
) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Image(
            painter = painter,
            contentDescription = contentDescription,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
        )
    }
}

@Preview
@Composable
fun PreviewProfileScreen() {
    ProfileScreen()
}