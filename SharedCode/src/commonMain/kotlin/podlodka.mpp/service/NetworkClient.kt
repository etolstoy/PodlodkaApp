package podlodka.mpp.service

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.url
import kotlin.native.concurrent.SharedImmutable
import kotlin.native.concurrent.ThreadLocal

@ThreadLocal
object NetworkClient {
    @SharedImmutable
    private var address = "http://51.158.182.28"
    @SharedImmutable
    private val client = HttpClient()

    suspend fun get(endpoint: String): String {
        return client.get {
            url("$address/$endpoint")
        }
    }
}