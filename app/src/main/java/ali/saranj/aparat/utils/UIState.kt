package ali.saranj.aparat.utils

sealed class UIState<out T : Any> {
    data class Success<out T : Any>(val data: T) : UIState<T>()
    data class Error(val exception: String) : UIState<Nothing>()
    data object Loading : UIState<Nothing>()
}
