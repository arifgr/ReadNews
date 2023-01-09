package com.example.readnews.domain.use_case.get_news

import com.example.readnews.common.Resource
import com.example.readnews.data.remote.dto.toArticle
import com.example.readnews.domain.model.Article
import com.example.readnews.domain.repository.ArticleRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetNews @Inject constructor(
    private val repository: ArticleRepository
) {
    operator fun invoke(
        searchQuery: String,
        from: String,
        to: String,
        pageNumber: Int,
        apiKey: String,
        sortBy: String
    ): Flow<Resource<List<Article>>> = flow {
        try {
            emit(Resource.Loading())
            val articles = repository.getNews(searchQuery, from, to, pageNumber, apiKey, sortBy)
                .map { it.toArticle() }
            emit(Resource.Success(articles))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        }
    }
}