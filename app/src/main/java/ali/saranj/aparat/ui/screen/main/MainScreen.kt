package ali.saranj.aparat.ui.screen.main

import ali.saranj.aparat.R
import ali.saranj.aparat.ui.components.navbottom.BottomNavigationBar
import ali.saranj.aparat.ui.screen.home.HomeScreen
import ali.saranj.aparat.ui.screen.profile.ProfileScreen
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

sealed class BottomNavItem(val route: String, val icon: Int, val label: String) {
    data object Home : BottomNavItem("home", R.drawable.home, "Home")
    data object Profile : BottomNavItem("profile", R.drawable.profile, "Profile")
    companion object {
        fun values(): List<BottomNavItem> {
            return listOf(
                Home,
                Profile
            )
        }
    }


}

@Composable
fun MainScreen(
    modifier: Modifier = Modifier
) {
    var navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) })
    { paddingValues ->
        AppNavHost(
            modifier = modifier.padding(paddingValues),
            navController = navController
        )
    }
}

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = BottomNavItem.Home.route,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(BottomNavItem.Home.route) {
            HomeScreen()
        }
        composable(BottomNavItem.Profile.route){
            ProfileScreen()
        }

    }
}

@Preview(name = "MainScreen")
@Composable
private fun PreviewMainScreen() {
    MainScreen()
}