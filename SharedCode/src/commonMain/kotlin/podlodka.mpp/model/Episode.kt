package podlodka.mpp.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Episode(
    val id: String,
    val number: Int,
    val name: String,
    val guests: List<Person>?,
    val hosts: List<Person>,
    @SerialName("description")
    val desc: String,
    val links: List<Link>,
    val src: String
)