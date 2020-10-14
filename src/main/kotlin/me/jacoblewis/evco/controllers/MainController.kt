package me.jacoblewis.evco.controllers

import me.jacoblewis.evco.baseUrl
import me.jacoblewis.evco.models.UrlMappingModel
import me.jacoblewis.evco.repos.UrlMappingRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.view.RedirectView
import javax.servlet.http.HttpServletRequest

@Component
@RestController
class MainController {

    @Autowired
    lateinit var urlsRepo: UrlMappingRepo

    @PostMapping("/urls")
    fun addURL(@RequestParam("alias") alias: String,
               @RequestParam("originalURL") originalURL: String): ResponseEntity<String> {
        if (urlsRepo.findByAlias(alias).isNotEmpty()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("alias already exists!")
        }
        urlsRepo.save(UrlMappingModel(alias, originalURL))
        return ResponseEntity.ok("saved $originalURL as $alias!")
    }

    @GetMapping("/{alias:^\\w+}")
    fun getURL(@PathVariable("alias") alias: String, request: HttpServletRequest): RedirectView {
        // use the original URL or default to the homepage if the alias has no match
        val originalURL = urlsRepo.findByAlias(alias).firstOrNull()?.originalURL ?: request.baseUrl
        return RedirectView(originalURL)
    }
}