package ru.podlodka.backend

import com.mongodb.MongoClient
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.MongoOperations
import ru.podlodka.backend.models.ShowEpisode


@SpringBootApplication
class PodlodkaBackendApplication

fun main(args: Array<String>) {
	runApplication<PodlodkaBackendApplication>(*args)
}
