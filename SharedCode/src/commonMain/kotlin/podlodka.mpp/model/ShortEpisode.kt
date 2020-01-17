package podlodka.mpp.model
import kotlinx.serialization.Serializable

@Serializable
data class ShortEpisode (
    val name: String,
    val guestName: String,
    val photoUrl: String
)