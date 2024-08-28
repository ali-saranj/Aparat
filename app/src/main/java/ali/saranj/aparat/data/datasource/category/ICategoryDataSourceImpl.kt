package ali.saranj.aparat.data.datasource.category

import ali.saranj.aparat.data.models.Category
import ali.saranj.aparat.data.network.IClientAparat
import ali.saranj.aparat.mapers.category.toCategory
import ali.saranj.aparat.utils.Response
import javax.inject.Inject

class ICategoryDataSourceImpl @Inject constructor(private var aparat: IClientAparat) :
    ICategoryDataSource {

    override suspend fun getCategories(): Response<List<Category>> {
        return try {
            val response = aparat.getCategories()

            if (response.isSuccessful) {
                Response.Success(response.body()!!.categories!!.map { it!!.toCategory() })
            } else {
                Response.Error(response.errorBody()?.string() ?: "An error occurred")
            }
        } catch (e: Exception) {
            Response.Error(e.message ?: "An error occurred")
        }
    }
}