package ru.podlodka.backend.repositories

import org.springframework.data.mongodb.repository.MongoRepository
import ru.podlodka.backend.models.Category

interface CategoryRepository: MongoRepository<Category, String>;