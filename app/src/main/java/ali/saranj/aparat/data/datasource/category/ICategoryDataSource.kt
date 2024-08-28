package ali.saranj.aparat.data.datasource.category

import ali.saranj.aparat.data.models.Category
import ali.saranj.aparat.utils.Response

interface ICategoryDataSource {
    suspend fun getCategories(): Response<List<Category>>
}