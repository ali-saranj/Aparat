package ali.saranj.aparat.data.network.dto.video


import com.google.gson.annotations.SerializedName

data class VideoDetale(
    @SerializedName("video")
    val video: VideoDto?
)