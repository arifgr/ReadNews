package com.example.readnews.data.remote.dto

import com.example.readnews.domain.model.Article

data class ArticleDto(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val sourceDto: SourceDto,
    val title: String,
    val url: String,
    val urlToImage: String
)

fun ArticleDto.toArticle(): Article {
    return Article(
        author = author,
        content = content,
        description = description,
        publishedAt = publishedAt,
        source = sourceDto.toSource(),
        title = title,
        url = url,
        urlToImage = urlToImage
    )
}