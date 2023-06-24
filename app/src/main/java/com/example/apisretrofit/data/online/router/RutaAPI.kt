package com.example.apisretrofit.data.online.router

import com.example.apisretrofit.data.online.model.ResponseLoginModel
import com.example.apisretrofit.data.online.model.ResponsePokemonAPI
import com.example.apisretrofit.data.online.model.UsuarioModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface RutaAPI {

    @GET("api/v2/pokemon/{pokemon}")
    suspend fun getPokemon(@Path("pokemon") namePokemon:String):Response<ResponsePokemonAPI>

    @POST("/myAPI/proData.php")
    suspend fun login(@Body user:UsuarioModel):Response<ResponseLoginModel>

}