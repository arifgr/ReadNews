package com.example.readnews.di

import com.example.readnews.common.Constants.BASE_URL
import com.example.readnews.data.remote.NewsApi
import com.example.readnews.data.repository.ArticleRepositoryImpl
import com.example.readnews.domain.repository.ArticleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build().create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideArticleRepository(api: NewsApi): ArticleRepository {
        return ArticleRepositoryImpl(api)
    }
}