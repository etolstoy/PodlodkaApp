package podlodka.mpp.model

import kotlinx.serialization.Serializable

@Serializable
data class Link(
    val id: String,
    val url: String,
    val name: String
)