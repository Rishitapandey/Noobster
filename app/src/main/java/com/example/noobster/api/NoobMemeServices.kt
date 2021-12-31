package com.example.noobster.api

import com.example.noobster.models.NoobMemeData
import retrofit2.Call
import retrofit2.http.GET

interface NoobMemeServices {
    @GET("gimme/10")
    fun getData(

    ): Call<NoobMemeData>
}