package ali.saranj.aparat.data.network.di

import ali.saranj.aparat.data.network.IClientAparat
import ali.saranj.aparat.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {


    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder().baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).build()


    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): IClientAparat = retrofit.create(IClientAparat::class.java)
}