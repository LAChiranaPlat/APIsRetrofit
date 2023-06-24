package com.example.apisretrofit.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.apisretrofit.R
import com.example.apisretrofit.data.online.model.UsuarioModel
import com.example.apisretrofit.data.online.service.ServicePokemon
import com.example.apisretrofit.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONArray
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    lateinit var layout: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        layout= ActivityMainBinding.inflate(layoutInflater)
        setContentView(layout.root)

        layout.apply {

            btnGetPokemon.setOnClickListener {

                lifecycleScope.launch {

                    var result= withContext(Dispatchers.IO){

                        try{

                            ServicePokemon().Login(UsuarioModel("huarseral","jireh"))

                        }catch (e:Exception){

                            Log.i("response",e.stackTraceToString())
                            Log.i("response",e.message.toString())

                            null
                        }


                    }

                    if(result!=null){

                        Log.i("response",result.toString())
                        Log.i("response",result.body().toString())
                        Log.i("response",result.body()!!.status.toString())
                        Log.i("response",result.body()!!.message)

                        val array=JSONArray( result.body()!!.result)

                        for (index in 0 until array.length()){

                            Log.i("json",array.getJSONObject(index).getString("lname").toString())
                        }



                    }

                }

            }

        }
    }

}