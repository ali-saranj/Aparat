package ali.saranj.aparat.utils

class Time {
    fun getFormattedTime(seconds: Int): String {
        val hours = seconds / 3600
        val minutes = (seconds % 3600) / 60
        val secs = seconds % 60
        return String.format("%02d:%02d:%02d", hours, minutes, secs)
    }

}

fun main() {
    val time = Time()
    println(time.getFormattedTime(10000))
}