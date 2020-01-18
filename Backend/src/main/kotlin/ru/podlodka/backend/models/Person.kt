package ru.podlodka.backend.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Person(
        @Id var id: String,
        // Имя человека
        val name: String,
        // Биография
        val bio: String,
        // Компания
        val company: String,
        // Фото
        val photoUrl: String
);