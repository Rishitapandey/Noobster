package com.example.noobster.models

import com.google.gson.annotations.SerializedName


data class NoobMemeData (

  @SerializedName("count" ) var count : Int?             = null,
  @SerializedName("memes" ) var memes : ArrayList<Memes> = arrayListOf()

)