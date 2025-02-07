package com.mobileexam.calope.data

import androidx.annotation.DrawableRes
import com.mobileexam.calope.R

data class Character(

    @DrawableRes val imageResourceId: Int,
    val name: String,
    val status: String,
    val specie: String,
    val type: String,
    val gender: String,
    val location: String,
    val origin: String
)


val character = listOf(
    Character( R.drawable.image1, "Rick Sanchez", "Alive", "Human","Type: ","Gender: Male","Location: Citadel of Ricks","Origin: Earth (C-137)"),
    Character( R.drawable.image2, "Morty Smith", "Alive", "Human","Type: ","Gender: Male","Location: Citadel of Ricks","Origin: Unknown"),
    Character( R.drawable.image3,"Summer Smith", "Alive", "Human","Type: ","Gender: Female","Location: Earth (Replacement Dimension)","Origin: Earth (Replacement Dimension)"),
    Character( R.drawable.image4, "Beth Smith", "Alive", "Human","Type: ","Gender: Female","Location: Earth (Replacement Dimension)","Origin: Earth (Replacement Dimension)"),
    Character( R.drawable.image5, "Jerry Smith", "Alive", "Human","Type: ","Gender: Male","Location: Earth (Replacement Dimension)","Origin: Earth (Replacement Dimension)"),
    Character( R.drawable.image6, "Abadango Cluster Princess", "Alive", "Alien","Type: ","Gender: Female","Location: Abadango","Origin: Abadango"),
    Character( R.drawable.image7, "Abradolf Lincler", "Unknown", "Human","Type: Genetic experiment","Gender: Male","Location: Testicle Monster Dimension","Origin: Earth (Replacement Dimension)"),
    Character( R.drawable.image8, "Adjudicator Rick", "Dead", "Human","Type: ","Gender: Male","Location: Citadel of Ricks","Origin: Unknown"),
    Character( R.drawable.image9, "Agency Director", "Dead", "Human","Type: ","Gender: Male","Location: Earth (Replacement Dimension)","Origin: Earth (Replacement Dimension)"),
    Character( R.drawable.image10, "Alan Rails", "Dead", "Human","Type: Superhuman (Ghost trains summoner)","Gender: Male","Location: Worldender's lair","Origin: Unknown"),
    Character( R.drawable.image11, "Albert Einstein", "Dead", "Human","Type: ","Gender: Male","Location: Earth (Replacement Dimension)","Origin: Earth (C-137)"),
    Character( R.drawable.image12, "Alexander", "Dead", "Human","Type: ","Gender: Male","Location: Anatomy Park","Origin: Earth (C-137)"),
    Character( R.drawable.image13, "Alien Googah", "Unknown", "Alien","Type: ","Gender: Unknown","Location: Earth (Replacement Dimension)","Origin: Unknown"),
    Character( R.drawable.image14, "Alien Morty", "Unknown", "Alien","Type: ","Gender: Male","Location: Citadel of Ricks","Origin: Unknown"),
    Character( R.drawable.image15, "Alien Rick", "Unknown", "Alien","Type: ","Gender: Male","Location: Citadel of Ricks","Origin: Unknown"),
    Character( R.drawable.image16, "Amish Cyborg", "Dead", "Alien","Type: Parasite","Gender: Male","Location: Earth (Replacement Dimension)","Origin: Unknown"),
    Character( R.drawable.image17, "Annie", "Alive", "Human","Type: ","Gender: Female","Location: Anatomy Park","Origin: Earth (C-137)"),
    Character( R.drawable.image18, "Antenna Morty", "Alive", "Human","Type: Human with antennae","Gender: Male","Location: Citadel of Ricks","Origin: Unknown"),
    Character( R.drawable.image19, "Antenna Rick", "Unknown", "Human","Type: Human with antennae","Gender: Male","Location: Unknown","Origin: Unknown"),
    Character( R.drawable.image20, "Ants in my Eyes Johnson", "Unknown", "Type: Human","Human with ants in his eyes","Gender: Male","Location: Interdimensional Cable","Origin: Unknown"),
)