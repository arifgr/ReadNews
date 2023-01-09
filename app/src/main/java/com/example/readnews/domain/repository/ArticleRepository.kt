package com.example.readnews.domain.repository

import com.example.readnews.data.remote.dto.ArticleDto

interface ArticleRepository {
    suspend fun getNews(
        searchQuery: String,
        from: String,
        to: String,
        pageNumber: Int,
        apiKey: String,
        sortBy: String
    ): List<ArticleDto>
}