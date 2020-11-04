package com.example.googlebooks.Model


import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("volumeInfo")
    val volumeInfo: VolumeInfo

)