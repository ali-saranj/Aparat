package ali.saranj.aparat.data.repository.category

import ali.saranj.aparat.data.models.Category
import ali.saranj.aparat.utils.Response
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {
    suspend fun getCategories(): Flow<Response<List<Category>>>
}