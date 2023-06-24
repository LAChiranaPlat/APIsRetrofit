package com.example.apisretrofit.data.online.service

import com.example.apisretrofit.core.objRetrofit
import com.example.apisretrofit.data.online.model.ResponseLoginModel
import com.example.apisretrofit.data.online.model.ResponsePokemonAPI
import com.example.apisretrofit.data.online.model.UsuarioModel
import com.example.apisretrofit.data.online.router.RutaAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class ServicePokemon {

    private val retrofit=objRetrofit.getRetrofit()

    suspend fun verPokemon(namePokemon:String): Response<ResponsePokemonAPI> {

        return withContext(Dispatchers.IO){
            retrofit.create(RutaAPI::class.java).getPokemon(namePokemon)
        }
    }

    suspend fun Login(usuario:UsuarioModel): Response<ResponseLoginModel> {

        return withContext(Dispatchers.IO){
            retrofit.create(RutaAPI::class.java).login(usuario)
        }

    }

}