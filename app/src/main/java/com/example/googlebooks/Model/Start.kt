package com.example.googlebooks.Model


import com.google.gson.annotations.SerializedName

data class Start(
    val kind: String,
    val totalItems: Int,
    val items: ArrayList<Item>
)