package com.example.googlebooks

import android.app.AlertDialog
import android.os.Bundle
import android.os.Parcelable
import android.util.Log.d
import android.widget.Toast
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.googlebooks.Adapter.MyMovieAdapter
import com.example.googlebooks.Common.Common
import com.example.googlebooks.Interface.RetrofitServieces
import com.example.googlebooks.Model.Start
import dmax.dialog.SpotsDialog
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var mService: RetrofitServieces
    lateinit var mlayoutManager: LinearLayoutManager
    lateinit var adapter: MyMovieAdapter
    lateinit var dialog: AlertDialog
    lateinit var mlistState: Parcelable


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mService = Common.retrofitService
        recycler_view_id.setHasFixedSize(true)
        mlayoutManager = LinearLayoutManager(this)
        recycler_view_id.layoutManager = mlayoutManager
        dialog = SpotsDialog.Builder().setCancelable(true).setContext(this).build()








        search_button.setOnClickListener {
            d("ars", "onStart")
            if (edit_book.text.isEmpty()) {
                Toast.makeText(it.context, "enter the book", Toast.LENGTH_SHORT)
                    .show()
            } else {
                getAllMovieList()
            }
        }
    }

    private fun getAllMovieList() {
        dialog.show()

        mService.getMovieList(edit_book.text.toString()).enqueue(object : Callback<Start> {
            override fun onFailure(call: Call<Start>, t: Throwable) {
                d("ars", "onFali")
                dialog.dismiss()
            }

            override fun onResponse(
                call: Call<Start>,
                response: Response<Start>
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

