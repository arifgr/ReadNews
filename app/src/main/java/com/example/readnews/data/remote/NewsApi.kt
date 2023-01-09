package com.example.readnews.data.remote

import com.example.readnews.common.Constants.API_KEY
import com.example.readnews.data.remote.dto.ArticleDto
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("v2/everything")
    suspend fun getNews(
        @Query("q")
        searchQuery: String = "football",
        @Query("from")
        from: String,
        @Query("to")
        to: String,
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apiKey: String = API_KEY,
        @Query("sortBy")
        sortBy: String = "publishedAt"
    ): List<ArticleDto>
}