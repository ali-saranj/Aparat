package ali.saranj.aparat.ui.screen.home

sealed class HomeVideoState<out T : Any> {
    data class Success<out T : Any>(val data: T) : HomeVideoState<T>()
    data class Error(val exception: String) : HomeVideoState<Nothing>()
    data object Loading : HomeVideoState<Nothing>()
    data object NotCalledYet : HomeVideoState<Nothing>()
}
