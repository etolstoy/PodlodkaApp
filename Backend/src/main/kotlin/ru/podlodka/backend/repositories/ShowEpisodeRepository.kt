package ru.podlodka.backend.repositories

import org.springframework.data.mongodb.repository.MongoRepository
import ru.podlodka.backend.models.ShowEpisode

interface ShowEpisodeRepository: MongoRepository<ShowEpisode, String>;