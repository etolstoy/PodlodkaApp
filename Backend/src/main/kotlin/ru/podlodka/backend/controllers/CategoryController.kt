package ru.podlodka.backend.controllers

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.podlodka.backend.models.Category
import ru.podlodka.backend.service.CategoryService
import java.util.logging.Logger

@RestController
class CategoryController(val categoryService: CategoryService){

    val logger = Logger.getLogger(CategoryService::class.java.canonicalName);

    @GetMapping
    fun getAllCategories(): MutableMap<String, Collection<Category>> {
        val categoryMap = mutableMapOf<String, Collection<Category>>();
        categoryMap["categories"] = categoryService.getAllCategories();
        return categoryMap;
    }

    @GetMapping("/{id}")
    fun getCategoryDetail(@PathVariable("id") id: String): ResponseEntity<Category> {

        val category = categoryService.getCategoryById(id)
        logger.info("category $category");

        if(category == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND).body(category);
        }

        return ResponseEntity.ok(category);
    }
}