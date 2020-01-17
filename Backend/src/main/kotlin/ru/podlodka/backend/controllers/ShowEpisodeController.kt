package ru.podlodka.backend.controllers

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.podlodka.backend.models.Category
import ru.podlodka.backend.models.Selection
import ru.podlodka.backend.models.ShowEpisode
import ru.podlodka.backend.service.CategoryService
import ru.podlodka.backend.service.MockDataService
import ru.podlodka.backend.service.SelectionService
import ru.podlodka.backend.service.ShowEpisodeService
import java.util.logging.Logger

@RestController
class ShowEpisodeController(val showEpisodeService: ShowEpisodeService,
                            val mockDataService: MockDataService,
                            val categoryService: CategoryService,
                            val selectionService: SelectionService){

    val logger = Logger.getLogger(ShowEpisodeController::class.java.canonicalName);

    data class EpisodeWrapper(
            val episode: ShowEpisode,
            val categories: List<ShortCategory>,
            val selections: List<ShortSelection>
    )

    data class ShortCategory(
            val name: String?,
            val emoji: String?,
            val shortEpisodes: List<ShortEpisode>
    )

    data class ShortSelection(
            val name: String?,
            val imageUrl: String?,
            val shortEpisodes: List<ShortEpisode>
    )

    data class ShortEpisode(
            val name: String?,
            val guestName: String?,
            val photoUrl: String?
    )

    @GetMapping
    fun getAllShowEpisodes(): MutableMap<String, Collection<EpisodeWrapper>> {
        val episodeMap = mutableMapOf<String, Collection<EpisodeWrapper>>()
        val episodes = showEpisodeService.getAllShowEpisodes()

        episodeMap["showEpisodes"] = episodes.map {
            EpisodeWrapper(
                    it,
                    it.categoryIds.map {
                        val category = categoryService.getCategoryById(it)
                        val shortEpisodes = getShortEpisodesWithIds(category?.episodeIds)

                        ShortCategory(
                                category?.name,
                                category?.emoji,
                                shortEpisodes
                        )
                    },
                    it.selectionIds.map {
                        val selection = selectionService.getSelectionById(it)
                        val shortEpisodes = getShortEpisodesWithIds(selection?.episodeIds)

                        ShortSelection(
                                selection?.name,
                                selection?.imageUrl,
                                shortEpisodes
                        )
                    }
            )
        }
        return episodeMap
    }

    @GetMapping("/{id}")
    fun getShowEpisodeDetail(@PathVariable("id") id: String): ResponseEntity<ShowEpisode> {

        val episode = showEpisodeService.getShowEpisodeDetailById(id)
        logger.info("episode $episode");

        if(episode == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND).body(episode);
        }

        return ResponseEntity.ok(episode);
    }

    @GetMapping("/mock_data")
    fun mockData(): String {
        return mockDataService.mockData() ;
    }

    private fun getShortEpisodesWithIds(ids: List<String>?): List<ShortEpisode> {
        val episodes = showEpisodeService.getShowEpisodesWithIds(ids)
        return episodes.map {
            ShortEpisode(
                    it.name,
                    it.guests.first().name,
                    it.guests.first().photoUrl
            )
        }
    }

}