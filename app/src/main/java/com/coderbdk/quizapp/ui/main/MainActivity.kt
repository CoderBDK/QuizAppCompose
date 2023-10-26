package com.coderbdk.quizapp.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.coderbdk.quizapp.ui.main.home.HomeScreen
import com.coderbdk.quizapp.ui.theme.BackgroundColor
import com.coderbdk.quizapp.ui.theme.NavContainerColor
import com.coderbdk.quizapp.ui.theme.NavDefaultItemColor
import com.coderbdk.quizapp.ui.theme.NavSelectedItemColor
import com.coderbdk.quizapp.ui.theme.QuizAppTheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            QuizAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainUI()
                }
            }
        }
    }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainUI() {

    val navController = rememberNavController()

    Scaffold(
        containerColor = BackgroundColor,
        bottomBar = {
            BottomAppBar(
               containerColor = Color.Transparent
            ) {
                BottomNavigationBar(navController)
            }
        },
       /* floatingActionButton = {
            FloatingActionButton(
                onClick = { /* do something */ },
                containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
            ) {
                Icon(Icons.Filled.Add, "Localized description")
            }
        },*/
    ) { padding ->

        // Main(padding)
        Box(
            modifier = Modifier.padding(
                PaddingValues(
                    0.dp,
                    0.dp,
                    0.dp,
                    padding.calculateBottomPadding()
                )
            )
        ) {
            NavigationMenu(navController = navController)
        }

    }

}

@Composable
fun NavigationMenu(navController: NavHostController) {
    NavHost(navController, startDestination = NavigationItem.Home.route) {
        composable(NavigationItem.Home.route) {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                item {
                    HomeScreen()
                }
            }

        }
        composable(NavigationItem.Profile.route) {
            ProfileScreen()
        }
        composable(NavigationItem.Help.route) {
            HelpScreen()
        }
    }
}




@Composable
fun ProfileScreen() {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        item {

        }
    }
}

@Composable
fun HelpScreen() {

}


sealed class NavigationItem(var route: String, val icon: ImageVector?, var title: String) {
    object Home : NavigationItem("Home", Icons.Rounded.Home, "Home")
    object Profile : NavigationItem("Profile", Icons.Rounded.Person, "Profile")
    object Help : NavigationItem("Help", Icons.Rounded.Info, "Help")
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Profile,
        NavigationItem.Help
    )
    var selectedItem by remember { mutableIntStateOf(0) }
    var currentRoute by remember { mutableStateOf(NavigationItem.Home.route) }

    items.forEachIndexed { index, navigationItem ->
        if (navigationItem.route == currentRoute) {
            selectedItem = index
        }
    }

    NavigationBar(
        containerColor = NavContainerColor
    ) {
        items.forEachIndexed { index, item ->

            NavigationBarItem(
                alwaysShowLabel = true,
                icon = { Icon(item.icon!!, contentDescription = item.title) },
                label = { Text(item.title) },
                selected = selectedItem == index,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = NavSelectedItemColor,
                    unselectedIconColor = NavDefaultItemColor
                ),
                onClick = {
                    selectedItem = index
                    currentRoute = item.route
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    QuizAppTheme {
        MainUI()
    }
}
}
