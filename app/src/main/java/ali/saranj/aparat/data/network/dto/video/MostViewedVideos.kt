package ali.saranj.aparat.data.network.dto.video.mostviewed


import ali.saranj.aparat.data.network.dto.video.VideoDto
import com.google.gson.annotations.SerializedName

data class MostViewedVideos(
    @SerializedName("mostviewedvideos")
    val mostviewedvideos: List<VideoDto?>?,
    @SerializedName("ui")
    val ui: Ui?
)