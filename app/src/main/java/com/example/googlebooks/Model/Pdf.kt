package com.example.googlebooks.Model


import com.google.gson.annotations.SerializedName

data class Pdf(
    val isAvailable: Boolean,
    val acsTokenLink: String
)