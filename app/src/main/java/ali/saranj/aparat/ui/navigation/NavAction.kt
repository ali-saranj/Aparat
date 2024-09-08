package ali.saranj.aparat.ui.navigation

import androidx.navigation.NavHostController

class NavAction {
    var navHostController: NavHostController? = null

    fun navigateToVideoDetail() {
        navHostController?.navigate(NavigationItem.DetailVideo.route)
    }

    fun navigateToMain() {
        navHostController?.navigate(NavigationItem.Main.route)
    }

    fun navigateToCategoryDetail(categoryId: String) {
        navHostController?.navigate(NavigationItem.CategoryDetail.route + "?categoryId=$categoryId")
    }

    fun navigateBack() {
        navHostController?.popBackStack()
    }
}