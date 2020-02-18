package podlodka.mpp.module.episodeDetail

import podlodka.mpp.DatabaseHelper
import podlodka.mpp.model.EpisodeCategory
import podlodka.mpp.service.CategoryService

class EpisodeDetailViewModel {
    private val service = CategoryService()
    fun getCategories(callback: (List<EpisodeCategory>) -> Unit) {
        val helper = DatabaseHelper()
        val savedCategories = getSavedCategories()

        if (savedCategories != null) {

            service.getCategories {
                if (it != null) {
                    helper.insertEpisodeCategories(it)
                }
            }
            callback(savedCategories)
            return
        } else {
            service.getCategories {
                if (it != null) {
                    helper.insertEpisodeCategories(it)
                }

                val savedCategories = getSavedCategories()

                if (savedCategories != null) {
                    callback(savedCategories)
                }
            }
        }


    }

    private fun getSavedCategories(): List<EpisodeCategory>? {
        val helper = DatabaseHelper()
        val query = helper.selectAllEpisodeCategories()
        val savedCategories = query.executeAsList()

        if (savedCategories == null) {
            return null
        }

        val result = mutableListOf<EpisodeCategory>()
        savedCategories.forEach {
            val category = EpisodeCategory(
                it.id,
                it.name,
                it.emoji,
                it.episodeIds.split(",")
            )
            result += category
        }

        return result
    }
}