package com.example.googlebooks.Model


import com.google.gson.annotations.SerializedName

data class ReadingModes(
    val text: Boolean,
    val image: Boolean
)