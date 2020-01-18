package ru.podlodka.backend.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Selection(
        @Id var id: String,
        // Имя подборки выпусков
        val name: String,
        // Ссылка на обложку подборки
        val imageUrl: String,
        // Список выпусков в подборке
        var episodeIds: List<String>
);