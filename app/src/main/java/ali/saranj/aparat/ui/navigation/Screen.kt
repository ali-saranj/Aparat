package ali.saranj.aparat.ui.navigation

sealed class NavigationItem(val route: String) {
    data object Main : NavigationItem("Main")
    data object DetailVideo : NavigationItem("DetailVideo")
}