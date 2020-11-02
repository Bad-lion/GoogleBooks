package com.example.googlebooks.Model


import com.google.gson.annotations.SerializedName

data class Epub(
    val isAvailable: Boolean,
    val acsTokenLink: String
)