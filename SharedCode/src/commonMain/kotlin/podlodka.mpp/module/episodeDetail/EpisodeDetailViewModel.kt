package podlodka.mpp.module.episodeDetail

import podlodka.mpp.DatabaseHelper
import podlodka.mpp.model.EpisodeCategory
import podlodka.mpp.service.CategoryService

class EpisodeDetailViewModel {
    private val service = CategoryService()
    fun getCategories(callback: (List<EpisodeCategory>) -> Unit) {
        val helper = DatabaseHelper()


        service.getCategories {
            if (it != null) {
                helper.insertEpisodeCategories(it)
            }
            val query = helper.selectAllItems()
            val arr = query.executeAsList()
            print(arr)
            if (it != null) {
                callback(it)
            }
        }
    }
}