package ru.podlodka.backend.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Link(
        @Id var id: String,
        // Название ссылки
        val name: String,
        // Адрес ссылки
        val url: String
);