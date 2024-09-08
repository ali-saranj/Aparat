package ali.saranj.aparat.ui.screen.main

import ali.saranj.aparat.R
import ali.saranj.aparat.ui.components.navbottom.BottomNavigationBar
import ali.saranj.aparat.ui.components.toolbar.AparatToolBar
import ali.saranj.aparat.ui.screen.home.HomeScreen
import ali.saranj.aparat.ui.screen.home.HomeViewModel
import ali.saranj.aparat.ui.screen.profile.ProfileScreen
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

sealed class BottomNavItem(val route: String, val icon: Int, val label: String) {
    data object Home : BottomNavItem("home", R.drawable.home, "صفحه اصلی")
    data object Profile : BottomNavItem("profile", R.drawable.profile, "پروفایل")
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
        topBar = { AparatToolBar() },
        bottomBar = { BottomNavigationBar(navController) })
    { paddingValues ->
        AppNavHost(
            modifier = Modifier.padding(paddingValues = paddingValues),
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
        composable(BottomNavItem.Profile.route) {
            ProfileScreen()
        }

    }
}

@Preview(name = "MainScreen")
@Composable
private fun PreviewMainScreen() {
    MainScreen()
}