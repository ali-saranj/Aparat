package ali.saranj.aparat.data.repository.video

import ali.saranj.aparat.data.datasource.video.IVideoDataSourceImpl
import ali.saranj.aparat.data.models.Video
import ali.saranj.aparat.utils.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class VideoRepositoryImpl @Inject constructor(private var dataSourceImpl: IVideoDataSourceImpl) :
    VideoRepository {

    override suspend fun getMostViewedVideos(): Flow<Response<List<Video>>> = flow {
        when (val response = dataSourceImpl.getMostViewedVideos()) {
            is Response.Success -> emit(Response.Success(response.data))
            is Response.Error -> emit(Response.Error(response.exception))
        }
    }.flowOn(Dispatchers.IO)

    override suspend fun getCategoryVideos(id: Int, page: Int): Flow<Response<List<Video>>> = flow {
        when (val response = dataSourceImpl.getCategoryVideos(id, page)) {
            is Response.Success -> emit(Response.Success(response.data))
            is Response.Error -> emit(Response.Error(response.exception))
        }
    }.flowOn(Dispatchers.IO)

    override suspend fun getSearchVideos(query: String, page: Int): Flow<Response<List<Video>>> =
        flow {
            when (val response = dataSourceImpl.getSearchVideos(query, page)) {
                is Response.Success -> emit(Response.Success(response.data))
                is Response.Error -> emit(Response.Error(response.exception))
            }

        }.flowOn(Dispatchers.IO)

    override suspend fun getVideoDetails(id: String): Flow<Response<Video>> = flow {
        when (val response = dataSourceImpl.getVideoDetails(id)) {
            is Response.Success -> emit(Response.Success(response.data))
            is Response.Error -> emit(Response.Error(response.exception))
        }
    }.flowOn(Dispatchers.IO)
}