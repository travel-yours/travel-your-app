import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.travelyour.R

@Composable
fun BackgroundPage(icon: @Composable () -> Unit, content: @Composable () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
    Column(
        modifier = Modifier.fillMaxSize()
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
               .padding(start = 16.dp, top = 30.dp)){
               icon()
           }
        }
    }
        Surface(
            modifier = Modifier
                .padding(top = 250.dp)
                .fillMaxWidth()
                .fillMaxHeight(),
            color = Color.White,
            shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, top = 30.dp),
                verticalArrangement = Arrangement.Top
            ) {
                content() // Konten kolom yang diberikan melalui parameter content
            }
        }
    }
}

@Preview
@Composable
fun BackgroundPagePrev() {
    BackgroundPage(icon = { /*TODO*/ }) {
        
    }
}
