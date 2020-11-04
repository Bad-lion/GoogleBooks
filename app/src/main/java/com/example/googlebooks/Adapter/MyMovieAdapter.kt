package com.example.googlebooks.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.googlebooks.Model.start
import com.example.googlebooks.R
import kotlinx.android.synthetic.main.item_layout.view.*

class MyMovieAdapter(private val context: Context, private val movieList: ArrayList<start>):

    RecyclerView.Adapter<MyMovieAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val image: ImageView = itemView.poster
        val bookTitle: TextView = itemView.book_name
        val authors: TextView = itemView.author
        val year: TextView = itemView.year



        fun bind(listItem: start) {
            image.setOnClickListener {
            }

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount() = movieList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val listItem = movieList[position]
        holder.bind(listItem)

//        Glide.with(holder.itemView.getContext()).load(listItem.imageurl)
//            .into(holder.image)
        holder.bookTitle.text = listItem.items[position].volumeInfo.name

        holder.authors.text = listItem.items[position].volumeInfo.publisher

    }

}
