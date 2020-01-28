package podlodka.mpp.model

import kotlinx.serialization.Serializable

@Serializable
data class Episode(
    val id: String,
    val number: Int,
    val name: String,
    val guests: List<Person>?,
    val hosts: List<Person>,
    val desc: String,
    val links: List<Link>,
    val src: String,
    val created: Int,
    val length: Int,
    val categories: List<ShortCategory>,
    val selections: List<Selection>
)