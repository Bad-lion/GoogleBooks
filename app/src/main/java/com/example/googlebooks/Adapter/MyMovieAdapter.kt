package com.example.googlebooks.Adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.googlebooks.Model.Item
import com.example.googlebooks.R
import kotlinx.android.synthetic.main.item_layout.view.*


class MyMovieAdapter(private val context: Context, private val movieList: ArrayList<Item>) :


    RecyclerView.Adapter<MyMovieAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.poster
        val bookTitle: TextView = itemView.book_name
        val authors: TextView = itemView.author
        val year: TextView = itemView.year
        val pages: TextView = itemView.pages
        val rating: TextView = itemView.rating
        val info: RelativeLayout = itemView.reltivCard

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount() = movieList.size


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val listItem = movieList[position]


        var auth: String = ""
        try {
            for (i in listItem.volumeInfo.authors) {
                auth += i + "\n"
            }
        }
        catch (e: NullPointerException) {

        }
//        for (i in listItem.volumeInfo.authors) {
//                auth += i + "\n"
//            }


        try {
            Glide.with(holder.itemView.context).load(listItem.volumeInfo.imageLinks.smallThumbnail)
                .into(holder.image)
        }
        catch (e: NullPointerException) {

        }



        holder.bookTitle.text = listItem.volumeInfo.bookName
        holder.year.text = listItem.volumeInfo.publishedDate
        holder.authors.text = auth
        holder.pages.text = listItem.volumeInfo.pageCount.toString()
        holder.rating.text = listItem.volumeInfo.ratingsCount.toString()

        holder.info.setOnClickListener {
            val url = listItem.volumeInfo.infoLink
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            context.startActivity(intent)
        }
    }

}
