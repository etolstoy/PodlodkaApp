package podlodka.mpp.model

import kotlinx.serialization.Serializable
import podlodka.mpp.model.Link
import podlodka.mpp.model.Person

@Serializable
data class Episode(
    val id: String,
    val number: Int,
    val name: String,
    val guests: List<Person>?,
    val hosts: List<Person>,
    val description: String,
    val links: List<Link>,
    val src: String
)