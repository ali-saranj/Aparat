package ali.saranj.aparat.data.repository.video

import ali.saranj.aparat.data.models.Video
import ali.saranj.aparat.utils.Response
import kotlinx.coroutines.flow.Flow

interface VideoRepository {
    suspend fun getMostViewedVideos(): Flow<Response<List<Video>>>
    suspend fun getCategoryVideos(id: Int, page: Int): Flow<Response<List<Video>>>
    suspend fun getSearchVideos(query: String, page: Int): Flow<Response<List<Video>>>
    suspend fun getVideoDetails(id: String): Flow<Response<Video>>
}