package com.example.learnretrofit

import com.google.gson.annotations.SerializedName

data class BasePokemon(
    @SerializedName("next")
    val next : String,
    @SerializedName("previous")
    val previous : String,
    @SerializedName("results")
    val result : List<ResultPokemon>
)
