package me.jacoblewis.evco.repos

import me.jacoblewis.evco.models.UrlMappingModel
import org.springframework.data.mongodb.repository.MongoRepository

interface UrlMappingRepo : MongoRepository<UrlMappingModel, String> {
    fun findByAlias(alias: String): List<UrlMappingModel>
}