package podlodka.mpp

import kotlinx.serialization.Serializable
import podlodka.mpp.model.Episode
import podlodka.mpp.model.Person
import podlodka.mpp.model.Link

expect fun platformName(): String

fun createApplicationScreenMessage() : String {
    return "Kotlin Rocks on ${platformName()}"
}