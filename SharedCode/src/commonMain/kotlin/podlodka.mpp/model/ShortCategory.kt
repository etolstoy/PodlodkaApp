package podlodka.mpp.model

import kotlinx.serialization.Serializable

@Serializable
data class ShortCategory(
    val name: String,
    val emoji: String,
    val episodes: List<ShortEpisode>
)