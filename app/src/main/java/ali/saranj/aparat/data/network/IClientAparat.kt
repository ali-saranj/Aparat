package ali.saranj.aparat.data.network

import ali.saranj.aparat.data.network.dto.category.ListCategoryDto
import ali.saranj.aparat.data.network.dto.video.CategoryVideos
import ali.saranj.aparat.data.network.dto.video.VideoBySearch
import ali.saranj.aparat.data.network.dto.video.VideoDetale
import ali.saranj.aparat.data.network.dto.video.mostviewed.MostViewedVideos
import ali.saranj.aparat.utils.Constants
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface IClientAparat {
    @GET("etc/api/categories")
    suspend fun getCategories(): Response<ListCategoryDto>


    @GET("etc/api/mostviewedvideos")
    suspend fun getMostViewedVideos(): Response<MostViewedVideos>


    @GET("etc/api/categoryVideos/cat/{id}/perpage/{page}")
    suspend fun getCategoryVideos(
        @Path("id") id: Int,
        @Path("page") page: Int
    ): Response<CategoryVideos>

    @GET("/etc/api/videoBySearch/text/{text}/perpage/{page}")
    suspend fun getSearchVideos(
        @Path("text") text: String,
        @Path("page") page: Int
    ): Response<VideoBySearch>

    @GET("etc/api/video/videohash/{id}")
    suspend fun getVideoDetails(@Path("id") id: String): Response<VideoDetale>
}


suspend fun main() {
    val retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofit.create(IClientAparat::class.java)

    if (service.getVideoDetails("c457emw").isSuccessful) {
        println(service.getVideoDetails("c457emw").body()!!)
    } else {
        println("Error: ${service.getCategories().code()}")
    }
}