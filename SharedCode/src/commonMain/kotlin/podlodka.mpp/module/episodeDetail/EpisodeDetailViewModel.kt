package podlodka.mpp.module.episodeDetail

import podlodka.mpp.model.EpisodeCategory
import podlodka.mpp.service.CategoryService

class EpisodeDetailViewModel {
    private val service = CategoryService()
    fun getCategories(callback: (List<EpisodeCategory>) -> Unit) {
        service.getCategories {
            if (it != null) {
                callback(it)
            }
        }
    }
}