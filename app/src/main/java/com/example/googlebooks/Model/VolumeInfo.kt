package com.example.googlebooks.Model

import com.google.gson.annotations.SerializedName

data class VolumeInfo(

    @SerializedName("title")
    val bookName: String,
    @SerializedName("authors")
    val authors: ArrayList<String>,
    @SerializedName("publisher")
    val publisher: String,
    @SerializedName("publishedDate")
    val publishedDate: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("pageCount")
    val pageCount: Int,
//    @SerializedName("averageRating")
//    val averageRating: Int,
    @SerializedName("ratingsCount")
    val ratingsCount: Int,
    @SerializedName("imageLinks")
    val imageLinks: ImageLinks,
    @SerializedName("infoLink")
    val infoLink: String,
    @SerializedName("subtitle")
    val subtitle: String
)









