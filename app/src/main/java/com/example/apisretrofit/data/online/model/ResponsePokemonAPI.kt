package com.example.apisretrofit.data.online.model

import com.google.gson.annotations.SerializedName
import org.json.JSONArray
import org.json.JSONObject

data class ResponsePokemonAPI(
    @SerializedName("name")var nombrePokemon:String,
    @SerializedName("id") var idPokemon:Int,
    @SerializedName("order") var nOrdenPokemon:Int,
    var moves:ArrayList<String>,
)
