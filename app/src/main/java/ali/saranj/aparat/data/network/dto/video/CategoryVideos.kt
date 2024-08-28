package ali.saranj.aparat.data.network.dto.video


import ali.saranj.aparat.data.network.dto.video.mostviewed.Ui
import com.google.gson.annotations.SerializedName

data class CategoryVideos(
    @SerializedName("categoryvideos")
    val categoryvideos: List<VideoDto>?,
    @SerializedName("ui")
    val ui: Ui?
)