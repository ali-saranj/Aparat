package ali.saranj.aparat.mapers.category

import ali.saranj.aparat.data.models.Category
import ali.saranj.aparat.data.network.dto.category.CategoryDto

fun CategoryDto.toCategory() = Category(
    id = id,
    name = name!!,
    icon = imgSrc!!
)