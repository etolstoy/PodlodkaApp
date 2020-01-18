package podlodka.mpp.model

import kotlinx.serialization.Serializable

@Serializable
data class Selection(
    val name: String,
    val imageUrl: String,
    val episodes: List<ShortEpisode>
)