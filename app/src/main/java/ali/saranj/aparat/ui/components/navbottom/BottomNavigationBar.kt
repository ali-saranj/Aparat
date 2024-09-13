package ali.saranj.aparat.ui.components.navbottom

import ali.saranj.aparat.ui.screen.main.BottomNavItem
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun BottomNavigationBar(navController: NavController) {

    NavigationBar(containerColor = Color.White, tonalElevation = 4.dp, contentColor = Color.Black) {

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        BottomNavItem.values().forEach { item ->
            NavigationBarItem(
                colors = NavigationBarItemDefaults.colors(indicatorColor = Color(0xffea1d5d)),
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route)
                },
                icon = {
                    Icon(
                        modifier = Modifier.size(28.dp),
                        painter = painterResource(id = item.icon),
                        contentDescription = item.label,
                        tint = if (currentRoute == item.route) Color.White else Color.Black
                    )
                },
                label = {
                    Text(
                        text = item.label,
                        style = MaterialTheme.typography.bodyMedium,
                        color = if (currentRoute == item.route) Color(0xffea1d5d) else Color.Black
                    )
                }
            )
        }

    }
}

@Preview
@Composable
private fun BottomNavigationBarPreview() {
    BottomNavigationBar(navController = rememberNavController())
}

