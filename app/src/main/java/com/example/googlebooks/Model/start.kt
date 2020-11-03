package com.example.googlebooks.Model


import com.google.gson.annotations.SerializedName

data class start(
    val kind: String,
    val totalItems: Int,
    val items: List<Item>
)