package ali.saranj.aparat.ui.screen.home

sealed class HomeState<T> {
    data class Success<T>(val data: T) : HomeState<T>()
    data class Error(val exception: String) : HomeState<Nothing>()
    data object Loading : HomeState<Nothing>()

}