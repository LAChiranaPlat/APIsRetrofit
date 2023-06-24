package com.example.apisretrofit.data.online.model

import com.google.gson.annotations.SerializedName

data class PokemonModel(
    @SerializedName("name") var nombre:String
    )