package com.example.googlebooks.Model


import com.google.gson.annotations.SerializedName

data class Offer(
    val finskyOfferType: Int,
    val listPrice: ListPriceX,
    val retailPrice: RetailPriceX
)