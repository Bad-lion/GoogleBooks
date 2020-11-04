package com.example.googlebooks

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log.d
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.googlebooks.Adapter.MyMovieAdapter
import com.example.googlebooks.Common.Common
import com.example.googlebooks.Interface.RetrofitServieces
import com.example.googlebooks.Model.Item
import com.example.googlebooks.Model.start
import dmax.dialog.SpotsDialog
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.ResponseBody
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

        search_button.setOnClickListener {
            d("ars", "onStart")
            getAllMovieList()
        }
    }

    private fun getAllMovieList() {
        dialog.show()
        mService.getMovieList().enqueue(object : Callback<start> {
            override fun onFailure(call: Call<start>, t: Throwable) {
                d("ars", "onFali")
                dialog.dismiss()
            }
            override fun onResponse(
                call: Call<start>,
                response: Response<start>
            ) {
                d("ars", "onResp")
                adapter = MyMovieAdapter(baseContext, response.body()!!.items)
                adapter.notifyDataSetChanged()
                recycler_view_id.adapter = adapter

                dialog.dismiss()
            }
        })
    }
}

