package com.example.googlebooks

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log.d

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.googlebooks.Adapter.MyMovieAdapter
import com.example.googlebooks.Common.Common
import com.example.googlebooks.Interface.RetrofitServieces
import com.example.googlebooks.Model.Movie
import com.example.googlebooks.Model.VolumeInfo
import dmax.dialog.SpotsDialog
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var mService: RetrofitServieces
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: MyMovieAdapter
    lateinit var dialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mService = Common.retrofitService
        recyclerMovieList.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recyclerMovieList.layoutManager = layoutManager
        dialog = SpotsDialog.Builder().setCancelable(true).setContext(this).build()
        d("arst","before")

        getAllMovieList()
        d("arst","after")

    }

    private fun getAllMovieList() {
        dialog.show()
        mService.getMovieList("Sherlock","AIzaSyD3pE2fvwifghEI-jkZZtIQeGWtuhNn8UM").enqueue(object : Callback<MutableList<VolumeInfo>> {
            override fun onFailure(call: Call<MutableList<VolumeInfo>>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<MutableList<VolumeInfo>>,
                response: Response<MutableList<VolumeInfo>>
            ) {
                adapter = MyMovieAdapter(baseContext, response.body() as MutableList<VolumeInfo>)
                adapter.notifyDataSetChanged()
                recyclerMovieList.adapter = adapter

                dialog.dismiss()
            }
        })
    }
}
