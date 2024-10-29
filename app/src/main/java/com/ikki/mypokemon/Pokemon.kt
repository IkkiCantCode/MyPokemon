package com.ikki.mypokemon

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pokemon(
    val name : String,
    val kind : String,
    val photo : Int,
    val type: List<String>,
    val height : String,
    val weight : String,
    val ability : String,
    val hiddenAbility : String,
    val region: String,
    val generation : String,
    val entry : String
) : Parcelable



