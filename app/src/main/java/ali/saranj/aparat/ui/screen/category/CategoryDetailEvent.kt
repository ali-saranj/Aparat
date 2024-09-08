package ali.saranj.aparat.ui.screen.category

sealed class CategoryDetailEvent {
    data class LoadVideoByCategory(val categoryId: Int) : CategoryDetailEvent()
    data object BackToHomeScreen : CategoryDetailEvent()
}