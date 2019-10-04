package podlodka.module.episodeList

import podlodka.mpp.model.Episode
import podlodka.mpp.service.EpisodeService
import kotlinx.coroutines.*

class EpisodeListViewModel() {
    private val service = EpisodeService()
    fun getEpisodes(callback: (List<Episode>) -> Unit) {
        service.episodes {
            if (it != null) {
                callback(it)
            }
        }
    }
}

