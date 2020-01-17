package ru.podlodka.backend.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class ShowEpisode(
        @Id var id: String,
        // Название выпуска
        val name: String,
        // Номер выпуска
        val number: Int,
        // Дата выпуска
        val created: Int,
        // Длина выпуска
        val length: Int,
         // Описание выпуска
        val desc: String,
        // Ведущие, которые были в выпуске
        val hosts: List<Person>,
        // Гости выпуска
        val guests: List<Person>,
        // Ссылки на подкаст на разных площадках
        val links: List<Link>,
        // Основная ссылка с файлом
        val src: String,
        // Список категорий, в которые входит выпуск
        var categories: List<Category>,
        // Список подборок, в которые входит выпуск
        var selections: List<Selection>
);