package com.example.googlebooks.Interface

import com.example.googlebooks.Model.Movie
import com.example.googlebooks.Model.VolumeInfo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitServieces {
    @GET("volumes")
    fun getMovieList(@Query("q")title : String, @Query("key")key:String): Call<MutableList<VolumeInfo>>
}