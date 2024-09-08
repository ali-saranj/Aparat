package ali.saranj.aparat.ui.screen.home

import ali.saranj.aparat.data.models.Category

sealed class HomeUiEvent {
    data object LoadMostVideos : HomeUiEvent()
    data object LoadCategorise : HomeUiEvent()
    data class GetVideosByCategory(val category: Int) : HomeUiEvent()
    data class GoToCategoryDetails(val category: Category) : HomeUiEvent()
}