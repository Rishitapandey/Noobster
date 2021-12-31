package com.example.noobster.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.noobster.R
import com.example.noobster.models.Memes
import kotlinx.android.synthetic.main.item_character_details.view.*

class MemeAdapter (
    private val context: Context,
    private val MemeData:ArrayList<Memes>

) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private class MyViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_character_details, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is MyViewHolder) {
            holder.itemView.meme_title.text = MemeData[position].title
            Glide
                .with(context)
                .load(MemeData[position].preview[MemeData[position].preview.size-1])
                .into(holder.itemView.meme_image)
            holder.itemView.author.text = MemeData[position].author
        }
    }

    override fun getItemCount(): Int {
       return MemeData.size

    }
}


