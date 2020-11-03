package com.example.googlebooks

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log.d

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.googlebooks.Adapter.MyMovieAdapter
import com.example.googlebooks.Common.Common
import com.example.googlebooks.Interface.RetrofitServieces
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
        recycler_view_id.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recycler_view_id.layoutManager = layoutManager
        dialog = SpotsDialog.Builder().setCancelable(true).setContext(this).build()

        getAllMovieList()

    }

    private fun getAllMovieList() {
        dialog.show()
        mService.getMovieList("Sherlock").enqueue(object : Callback<List<VolumeInfo>> {

            override fun onFailure(call: Call<List<VolumeInfo>>, t: Throwable) {
                d("arst", "onFail")

            }
            override fun onResponse(
                call: Call<List<VolumeInfo>>,
                response: Response<List<VolumeInfo>>
            ) {
                d("arst", "onResp1")

                adapter = MyMovieAdapter(baseContext, response.body() as List<VolumeInfo>)
                d("arst", "onResp2")
                adapter.notifyDataSetChanged()
                recycler_view_id.adapter = adapter

                dialog.dismiss()

            }
        })
    }
}
