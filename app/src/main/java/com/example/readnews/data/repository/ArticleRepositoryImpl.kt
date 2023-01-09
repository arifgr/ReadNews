package com.example.readnews.data.repository

import com.example.readnews.data.remote.NewsApi
import com.example.readnews.data.remote.dto.ArticleDto
import com.example.readnews.domain.repository.ArticleRepository
import javax.inject.Inject

class ArticleRepositoryImpl @Inject constructor(
    private val api: NewsApi
) : ArticleRepository {
    override suspend fun getNews(
        searchQuery: String,
        from: String,
        to: String,
        pageNumber: Int,
        apiKey: String,
        sortBy: String
    ): List<ArticleDto> {
        return api.getNews(searchQuery, from, to, pageNumber, apiKey, sortBy)
    }
}