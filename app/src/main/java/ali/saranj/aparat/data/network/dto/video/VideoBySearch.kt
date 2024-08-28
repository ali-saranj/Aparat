package ali.saranj.aparat.data.network.dto.video


import ali.saranj.aparat.data.network.dto.video.mostviewed.Ui
import com.google.gson.annotations.SerializedName

data class VideoBySearch(
    @SerializedName("ui")
    val ui: Ui?,
    @SerializedName("videobysearch")
    val videobysearch: List<VideoDto>?
)