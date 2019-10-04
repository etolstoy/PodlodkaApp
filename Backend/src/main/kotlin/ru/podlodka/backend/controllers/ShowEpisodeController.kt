package ru.podlodka.backend.controllers

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.podlodka.backend.models.ShowEpisode
import ru.podlodka.backend.service.ShowEpisodeService
import java.util.logging.Logger

@RestController
class ShowEpisodeController(val showEpisodeService: ShowEpisodeService){

    val logger = Logger.getLogger(ShowEpisodeController::class.java.canonicalName);

    @GetMapping
    fun getAllShowEpisodes(): MutableMap<String, Collection<ShowEpisode>> {
        val episodeMap = mutableMapOf<String, Collection<ShowEpisode>>();
        episodeMap["showEpisodes"] = showEpisodeService.getAllShowEpisodes();
        return episodeMap;
    }


    @GetMapping("/{id}")
    fun getProductDetail(@PathVariable("id") id: String): ResponseEntity<ShowEpisode> {

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
        return showEpisodeService.mockData() ;
    }

}