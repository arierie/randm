package dev.arie.randm.model

data class Character(
    val id: String,
    val image: String,
    val name: String,
    val origin: Origin,
    val status: String,
    val type: String,
    val species: String
)
