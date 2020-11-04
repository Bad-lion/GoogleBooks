package com.example.googlebooks.Model


import com.google.gson.annotations.SerializedName

data class VolumeInfo(
    @SerializedName("title")
    var name: String,
    @SerializedName("authors")
    var authors: ArrayList<String>,
    @SerializedName("publisher")
    var publisher: String,
    @SerializedName("description")
    var description: String,
    @SerializedName("id")
    var pageCount: Int,
    @SerializedName("userId")
    var ratingsCount: Int
)