package podlodka.mpp.model

import kotlinx.serialization.Serializable

@Serializable
data class Person(
    val id: String,
    val name: String,
    val bio: String,
    val company: String
)