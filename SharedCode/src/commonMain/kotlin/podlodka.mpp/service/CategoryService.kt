package podlodka.mpp.service

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.serialization.KSerializer
import kotlinx.serialization.internal.ArrayListSerializer
import kotlinx.serialization.internal.StringSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.map
import podlodka.mpp.model.EpisodeCategory

class CategoryService {
    fun getCategories(callback: (List<EpisodeCategory>?) -> Unit) {
        GlobalScope.apply {
            launch(ApplicationDispatcher) {
                val response = NetworkClient.get("category")
                val serializer: KSerializer<List<EpisodeCategory>> = ArrayListSerializer(EpisodeCategory.serializer())
                val result = Json.parse((StringSerializer to serializer).map, response)

                callback(result["categories"])
            }
        }
    }
}