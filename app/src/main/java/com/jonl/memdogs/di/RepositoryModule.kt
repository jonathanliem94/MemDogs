package com.jonl.memdogs.di

import com.jonl.memdogs.data.NetworkRepository
import com.jonl.memdogs.data.NetworkService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

private const val BASE_URL = "https://dog.ceo/api/"

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideNetworkRepository(service: NetworkService): NetworkRepository {
        return NetworkRepository(service)
    }

    @Provides
    fun provideNetworkService(): NetworkService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(
                Json.asConverterFactory(
                    ("application/json; charset=UTF8").toMediaType()
                )
            )
            .build()
        return retrofit.create(NetworkService::class.java)
    }
}