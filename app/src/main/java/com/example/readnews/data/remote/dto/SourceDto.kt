package com.example.readnews.data.remote.dto

import com.example.readnews.domain.model.Source

data class SourceDto(
    val id: String,
    val name: String
)

fun SourceDto.toSource(): Source {
    return Source(
        id = id,
        name = name
    )
}