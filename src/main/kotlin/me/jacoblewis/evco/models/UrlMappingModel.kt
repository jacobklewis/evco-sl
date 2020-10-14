package me.jacoblewis.evco.models

import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "urls")
data class UrlMappingModel(
        val alias: String?,
        val originalURL: String?
)