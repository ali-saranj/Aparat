package ali.saranj.aparat.data.repository.category

import ali.saranj.aparat.data.datasource.category.ICategoryDataSourceImpl
import ali.saranj.aparat.data.models.Category
import ali.saranj.aparat.utils.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(private val dataSourceImpl: ICategoryDataSourceImpl) : CategoryRepository {
    override suspend fun getCategories(): Flow<Response<List<Category>>> = flow {
        when (val response = dataSourceImpl.getCategories()) {
            is Response.Success -> emit(Response.Success(response.data))
            is Response.Error -> emit(Response.Error(response.exception))
        }
    }.flowOn(Dispatchers.IO)
}