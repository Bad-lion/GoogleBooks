package com.example.googlebooks.Model



import com.google.gson.annotations.SerializedName

data class Item(

    @SerializedName("volumeInfo")
    val volumeInfo: VolumeInfo,
    @SerializedName("kind")
    val kind: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("etag")
    val etag: String,
    @SerializedName("selfLink")
    val selfLink: String

)