package podlodka.mpp.model

import kotlinx.serialization.Serializable

@Serializable
class EpisodeCategory (
    val id: String,
    val name: String,
    val emoji: String,
    val episodeIds: List<String>
)