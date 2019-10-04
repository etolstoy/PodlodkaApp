package podlodka.mpp.service

import io.ktor.client.*
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.coroutines.*
import kotlinx.serialization.*
import kotlinx.serialization.internal.ArrayListSerializer
import kotlinx.serialization.internal.StringSerializer
import kotlinx.serialization.json.Json
import podlodka.mpp.model.Episode


internal expect val ApplicationDispatcher: CoroutineDispatcher

class EpisodeService {
    private val client = HttpClient()

    var address = Url("http://51.158.182.28")

    fun episodes(callback: (List<Episode>?) -> Unit) {
        GlobalScope.apply {
            launch(ApplicationDispatcher) {
                val result: String = client.get {
                    url(this@EpisodeService.address.toString())
                }
                val serializer: KSerializer<List<Episode>> = ArrayListSerializer(Episode.serializer())
                val t = Json.parse((StringSerializer to serializer).map, result)

                callback(t["showEpisodes"])
            }
        }
    }
}