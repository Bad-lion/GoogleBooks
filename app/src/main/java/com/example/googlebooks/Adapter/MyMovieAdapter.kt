package com.example.googlebooks.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.googlebooks.Model.VolumeInfo
import com.example.googlebooks.R

import kotlinx.android.synthetic.main.item_layout.view.*

class MyMovieAdapter(private val context: Context, private val movieList: List<VolumeInfo>):
    RecyclerView.Adapter<MyMovieAdapter.MyViewHolder>() {


    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val image: ImageView = itemView.poster
        val titel: TextView = itemView.book_name
        val year: TextView = itemView.year
        val authors: TextView = itemView.author

//        fun bind(listItem: VolumeInfo) {
//            image.setOnClickListener {
//                Toast.makeText(it.context, "нажал на ${itemView.image_movie}", Toast.LENGTH_SHORT)
//                    .show()
//            }
//            itemView.setOnClickListener {
//                Toast.makeText(it.context, "нажал на ${itemView.txt_name.text}", Toast.LENGTH_SHORT).show()
//            }
//        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount() = movieList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val listItem = movieList[position]
//        holder.bind(listItem)
        holder.titel.text = listItem.name
        holder.authors.text = listItem.authors[0]

    }

}
