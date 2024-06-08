package com.emreozcan.emreozcan.features.detail.domain.models

/**
 * Created by @Emre Özcan on 8.06.2024
 */
data class CharacterDetailModel(
    val name: String,
    val status: Status,
    val gender: Gender,
    val image: String,
    val origin: String,
    val location: String,
    val species: String,
    val episodes: String,
)

fun getCharacterDetailMock() =
    CharacterDetailModel(
        name = "Rick Sanchez",
        status = Status.ALIVE,
        gender = Gender.MALE,
        image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
        origin = "Earth (C-137)",
        location = "Citadel of Ricks",
        species = "Human",
        episodes =
            "1, " +
                "2, " +
                "3, " +
                "4, " +
                "5, " +
                "6, " +
                "7, " +
                "8, " +
                "9, " +
                "10, " +
                "11, " +
                "12, " +
                "13, " +
                "14, " +
                "15, " +
                "16, " +
                "17, " +
                "18, " +
                "19, " +
                "20, " +
                "21, " +
                "22, " +
                "23, " +
                "24, " +
                "25 ",
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
