package ali.saranj.aparat.ui.screen.home

sealed class HomeUiEvent {
    data object LoadMostVideos : HomeUiEvent()
    data object LoadCategorise : HomeUiEvent()
    data class GetVideosByCategory(val category: Int) : HomeUiEvent()
}