package com.example.noobster

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noobster.models.NoobMemeData
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var memeAdapter: MemeAdapter
    private lateinit var linearlayoutManager: LinearLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getdata()
        linearlayoutManager = LinearLayoutManager(this)
        meme_list.layoutManager = linearlayoutManager


    }

    private fun getdata() {

        val retrofitBuilder=Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .build()
            .create(NoobMemeServices::class.java)
        val retroData=retrofitBuilder.getData()

        retroData.enqueue(object : Callback<NoobMemeData?> {
            override fun onResponse(
                call: Call<NoobMemeData?>,
                response: Response<NoobMemeData?>
            ) {
                val responseBody = response.body()
                if (responseBody != null) {
                    Log.e(" Meme data", responseBody.toString())
                    memeAdapter =
                        MemeAdapter(this@MainActivity, responseBody.memes)
                    meme_list.adapter = memeAdapter
                    progress_bar_main.visibility = View.GONE

                }
            }

            override fun onFailure(call: Call<NoobMemeData?>, t: Throwable) {
                Log.d("Main Activity", "onFailure:  ", t)
            }
        })
    }
}