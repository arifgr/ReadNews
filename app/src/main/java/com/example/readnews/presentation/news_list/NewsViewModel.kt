package com.example.readnews.presentation.news_list

import androidx.lifecycle.ViewModel
import com.example.readnews.domain.use_case.get_news.GetNews
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val getNews: GetNews
) : ViewModel() {
    fun getNews(
        searchQuery: String,
        from: String,
        to: String,
        pageNumber: Int,
        apiKey: String,
        sortBy: String
    ) = getNews.invoke(searchQuery, from, to, pageNumber, apiKey, sortBy)
}