package ali.saranj.aparat.utils

sealed class Response<out T> {
    data class Success<out T>(val data: T) : Response<T>()
    data class Error(val exception: String) : Response<Nothing>()
}