package ali.saranj.aparat.data.datasource.video

import ali.saranj.aparat.data.models.Video
import ali.saranj.aparat.data.network.IClientAparat
import ali.saranj.aparat.mapers.video.toVideo
import ali.saranj.aparat.utils.Response
import javax.inject.Inject

class IVideoDataSourceImpl @Inject constructor(private val aparatApi: IClientAparat) : IVideoDataSource {

    override suspend fun getMostViewedVideos(): Response<List<Video>> {
        return try {
            val response = aparatApi.getMostViewedVideos()

            if (response.isSuccessful) {
                Response.Success(response.body()!!.mostviewedvideos!!.map { it!!.toVideo() })
            } else {
                Response.Error(response.errorBody()?.string() ?: "An error occurred")
            }
        } catch (e: Exception) {
            Response.Error(e.message ?: "An error occurred")
        }

    }

    override suspend fun getVideoByCategory(id: Int, page: Int): Response<List<Video>> {
        return try {
            val response = aparatApi.getVideoByCategory(id, page)

            if (response.isSuccessful) {
                Response.Success(response.body()!!.categoryvideos!!.map { it.toVideo() })
            } else {
                Response.Error(response.errorBody()?.string() ?: "An error occurred")
            }
        } catch (e: Exception) {
            Response.Error(e.message ?: "An error occurred")
        }
    }

    override suspend fun getVideoDetails(id: String): Response<Video> {
        return try {
            val response = aparatApi.getVideoDetails(id)

            if (response.isSuccessful) {
                Response.Success(response.body()!!.video!!.toVideo())
            } else {
                Response.Error(response.errorBody()?.string() ?: "An error occurred")
            }
        } catch (e: Exception) {
            Response.Error(e.message ?: "An error occurred")
        }
    }

    override suspend fun getSearchVideos(text: String, page: Int): Response<List<Video>> {
        return try {
            val response = aparatApi.getSearchVideos(text, page)

            if (response.isSuccessful) {
                Response.Success(response.body()!!.videobysearch!!.map { it.toVideo() })
            } else {
                Response.Error(response.errorBody()?.string() ?: "An error occurred")
            }
        } catch (e: Exception) {
            Response.Error(e.message ?: "An error occurred")
        }
    }
}