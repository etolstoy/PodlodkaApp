package ru.podlodka.backend.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Category(
        @Id var id: String,
        // Имя категории выпусков
        val name: String,
        // Emoji этой категории
        val emoji: String,
        // Список выпусков в категории
        val episodes: List<ShowEpisode>
);