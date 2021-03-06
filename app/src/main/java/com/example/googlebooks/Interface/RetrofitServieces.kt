package com.example.googlebooks.Interface

import com.example.googlebooks.Model.Item
import com.example.googlebooks.Model.Start

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface RetrofitServieces {
    @GET("books/v1/volumes")
    fun getMovieList(@Query("q")title: String): Call<Start>

}
