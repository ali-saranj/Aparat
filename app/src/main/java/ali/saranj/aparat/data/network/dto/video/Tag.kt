package ali.saranj.aparat.data.network.dto.video


import com.google.gson.annotations.SerializedName

data class Tag(
    @SerializedName("name")
    val name: String?,
    @SerializedName("video_cnt")
    val videoCnt: String?
)