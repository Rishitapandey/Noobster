package com.example.noobster

import com.example.noobster.models.NoobMemeData
import retrofit2.Call
import retrofit2.http.GET

interface NoobMemeServices {
    @GET("/10")
    fun getData(


    ): Call<NoobMemeData>
}