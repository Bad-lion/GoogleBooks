package com.example.googlebooks.Common


import com.example.googlebooks.Interface.RetrofitServieces
import com.example.googlebooks.Retrofit.RetrofitClient

object Common {
    private val BASE_URL = "https://www.googleapis.com/books/v1/"
    val retrofitService: RetrofitServieces
        get() = RetrofitClient.getClient(BASE_URL).create(RetrofitServieces::class.java)
}