package ali.saranj.aparat.data.datasource.video

import ali.saranj.aparat.data.models.Video
import ali.saranj.aparat.utils.Response

interface IVideoDataSource {

    suspend fun getMostViewedVideos(): Response<List<Video>>

    suspend fun getCategoryVideos(id: Int, page: Int): Response<List<Video>>

    suspend fun getVideoDetails(id: String): Response<Video>

    suspend fun getSearchVideos(text: String, page: Int): Response<List<Video>>

}