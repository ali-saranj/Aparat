package ali.saranj.aparat.data.network.dto.category


import com.google.gson.annotations.SerializedName

data class CategoryDto(
    @SerializedName("id")
    val id: String?,
    @SerializedName("imgSrc")
    val imgSrc: String?,
    @SerializedName("link")
    val link: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("patternBgColor")
    val patternBgColor: String?,
    @SerializedName("patternBgSrc")
    val patternBgSrc: String?,
    @SerializedName("patternIconSrc")
    val patternIconSrc: String?,
    @SerializedName("videoCnt")
    val videoCnt: String?
)