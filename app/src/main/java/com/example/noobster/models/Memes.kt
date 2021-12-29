package com.example.noobster.models

import com.google.gson.annotations.SerializedName


data class Memes (

  @SerializedName("postLink"  ) var postLink  : String?           = null,
  @SerializedName("subreddit" ) var subreddit : String?           = null,
  @SerializedName("title"     ) var title     : String?           = null,
  @SerializedName("url"       ) var url       : String?           = null,
  @SerializedName("nsfw"      ) var nsfw      : Boolean?          = null,
  @SerializedName("spoiler"   ) var spoiler   : Boolean?          = null,
  @SerializedName("author"    ) var author    : String?           = null,
  @SerializedName("ups"       ) var ups       : Int?              = null,
  @SerializedName("preview"   ) var preview   : ArrayList<String> = arrayListOf()

)