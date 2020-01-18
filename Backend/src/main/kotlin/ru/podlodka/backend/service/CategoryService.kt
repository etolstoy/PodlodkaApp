package ru.podlodka.backend.service

import ru.podlodka.backend.repositories.CategoryRepository
import org.springframework.stereotype.Service
import ru.podlodka.backend.models.Category

@Service
class CategoryService(val categoryRepository: CategoryRepository){

    fun getAllCategories(): Collection<Category> {
        return categoryRepository.findAll();
    }

    fun getCategoryById(id: String): Category? {
        val category = categoryRepository.findById(id);
        if(!category.isPresent) {
            throw Exception("Category id=$id not found")
        }
        return category.get();
    }
}