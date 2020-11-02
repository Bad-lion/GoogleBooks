package com.example.googlebooks.Model


import com.google.gson.annotations.SerializedName

data class ListPriceX(
    val amountInMicros: Int,
    val currencyCode: String
)