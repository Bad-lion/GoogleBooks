package com.example.googlebooks.Model


import com.google.gson.annotations.SerializedName

data class VolumeInfo(
    @SerializedName("title")
    val name: String,
    @SerializedName("authors")
    val authors: List<String>,
    @SerializedName("publisher")
    val publisher: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("pageCount")
    val pageCount: Int,
    @SerializedName("ratingsCount")
    val ratingsCount: Int
)