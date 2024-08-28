package ali.saranj.aparat.data.network.dto.video.mostviewed


import com.google.gson.annotations.SerializedName

data class Ui(
    @SerializedName("pagingBack")
    val pagingBack: String?,
    @SerializedName("pagingForward")
    val pagingForward: String?
)