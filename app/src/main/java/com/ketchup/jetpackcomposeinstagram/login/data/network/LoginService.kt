package com.ketchup.jetpackcomposeinstagram.login.data.network

import com.ketchup.jetpackcomposeinstagram.core.network.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LoginService {
    private val retrofit = RetrofitHelper.getRetrofit() //Creamos nuestro retrofit

    suspend fun doLogin(user:String, password:String):Boolean{ //Creamos fun que recibira user y password
        return withContext(Dispatchers.IO){ //Definimos el hilo que vamos a usar (IO)
            val response = retrofit.create(LoginClient::class.java).doLogin(/* user, password */)  //llamamos nuestro retrofit y llamamos nuestro cliente, asi podremos llamar la funcion doLogin pasando user y password
            response.body()?.success ?: false //Usamos la respuesta de response para obtener la respuesta de nuestro objeto => ?: false significa que si es nulo retorne false
        }
    }
}