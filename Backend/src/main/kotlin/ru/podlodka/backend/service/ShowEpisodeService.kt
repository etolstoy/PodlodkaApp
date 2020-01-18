package ru.podlodka.backend.service

import ru.podlodka.backend.repositories.ShowEpisodeRepository
import org.springframework.stereotype.Service
import ru.podlodka.backend.models.ShowEpisode
import ru.podlodka.backend.models.Person
import ru.podlodka.backend.models.Link

@Service
class ShowEpisodeService(val showEpisodeRepository: ShowEpisodeRepository){

    fun getAllShowEpisodes(): Collection<ShowEpisode> {
        return showEpisodeRepository.findAll();
    }

    fun getShowEpisodesWithIds(ids: List<String>?): List<ShowEpisode> {
        val result = mutableListOf<ShowEpisode>()
        ids?.forEach {
            val episode = showEpisodeRepository.findById(it).get()
            result.add(episode)
        }
        return result.toList()
    }

    fun getShowEpisodeDetailById(id: String): ShowEpisode? {
        val episode = showEpisodeRepository.findById(id);
        if(!episode.isPresent) {
            throw Exception("ShowEpisode id=$id not found")
        }
        return episode.get();
    }
}