package ali.saranj.aparat.data.network.dto.category


import com.google.gson.annotations.SerializedName

data class ListCategoryDto(
    @SerializedName("categories")
    val categories: List<CategoryDto?>?
)