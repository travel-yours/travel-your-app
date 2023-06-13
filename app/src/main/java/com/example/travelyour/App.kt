package com.example.travelyour

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.travelyour.data.repository.UserPreferenceImpl
import com.example.travelyour.domain.UserPreferenceRepository
import com.example.travelyour.external.navigation.NavigationItem
import com.example.travelyour.external.navigation.Screen
import com.example.travelyour.external.navigation.SetupNavGraph
import com.example.travelyour.presentation.camera.CameraActivity
import kotlinx.coroutines.flow.map


@SuppressLint("FlowOperatorInvokedInComposition")
@Composable
fun App(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),

) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination?.route
  Scaffold(
      bottomBar = {
          if (currentDestination in listOf(Screen.Home.route,Screen.HomeTimeline.route)){
              BottomBar(navController)
          }

                  },
      modifier = modifier
      ) {innerPadding ->
      SetupNavGraph(navController = navController, modifier = Modifier.padding(innerPadding))

      if (currentDestination == Screen.Camera.route){
          val context = LocalContext.current
          LaunchedEffect(Unit){
              launchCameraActivity(context)
          }
      }


  }


}

private fun launchCameraActivity(context: Context){
    val intent = Intent(context, CameraActivity::class.java)
    context.startActivity(intent)
}

@Composable
private fun BottomBar(
  navController: NavHostController
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination?.route
    val navigationItems = listOf(
        NavigationItem(
            title = "Home",
            icon = Icons.Default.Home,
            screen = Screen.Home
        ),
        NavigationItem(
            title = "Timeline",
            icon = Icons.Default.Home,
            screen = Screen.HomeTimeline
        ),
        NavigationItem(
            title = "Camera",
            icon = Icons.Default.Home,
            screen = Screen.Camera
        ),
        NavigationItem(
            title = "Home",
            icon = Icons.Default.Home,
            screen = Screen.Home
        ),
        NavigationItem(
            title = "Home",
            icon = Icons.Default.Home,
            screen = Screen.Home
        ),
    )
    NavigationBar(
        modifier = Modifier
            .fillMaxWidth(),
        containerColor = Color.Blue
    ) {
        navigationItems.map { item ->
            NavigationBarItem(
                icon ={
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title)
                },
                label = { Text(item.title)},
                selected = currentDestination == item.screen.route,
                onClick = {

                    navController.navigate(item.screen.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            restoreState = true
                            launchSingleTop = true
                        }



                }

            )

                
            }
        }
    }

@Preview
@Composable
fun BottomBarPrev(

) {


}