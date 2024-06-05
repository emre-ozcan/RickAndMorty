package com.emreozcan.rickandmorty.home.domain.models

/**
 * Created by @Emre Özcan on 4.06.2024
 */
data class CharacterModel(
    val id: Int,
    val name: String,
    val status: Status,
    val gender: Gender,
    val image: String,
    val origin: String,
    val location: String,
)

fun getMockCharacterModel(): CharacterModel =
    CharacterModel(
        id = 1,
        name = "Rick Sanchez",
        status = Status.ALIVE,
        gender = Gender.MALE,
        image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
        origin = "Earth (C-137)",
        location = "Citadel of Ricks",
    )

enum class Status(val status: String) {
    ALIVE("Alive"),
    DEAD("Dead"),
    UNKNOWN("Unknown"),
}

fun convertToStatus(status: String?): Status {
    return when (status) {
        "Alive" -> Status.ALIVE
        "Dead" -> Status.DEAD
        else -> Status.UNKNOWN
    }
}

enum class Gender(val gender: String) {
    FEMALE("Female"),
    MALE("Male"),
    GENDERLESS("Genderless"),
    UNKNOWN("Unknown"),
}

fun convertToGender(gender: String?): Gender {
    return when (gender) {
        "Female" -> Gender.FEMALE
        "Male" -> Gender.MALE
        "Genderless" -> Gender.GENDERLESS
        else -> Gender.UNKNOWN
    }
}
