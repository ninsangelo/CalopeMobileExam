package com.mobileexam.calope.data

import com.google.gson.annotations.SerializedName

data class CharacterResponse(
    val results: List<Character>
)

data class Character(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String?,
    val gender: String,
    val image: String,
    val origin: Origin,
    val location: Location
)

data class Origin(
    val name: String
)

data class Location(
    val name: String
)
