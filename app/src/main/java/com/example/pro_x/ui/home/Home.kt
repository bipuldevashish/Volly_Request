package com.example.pro_x.ui.home

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.pro_x.data.api.RequestJson
import com.example.pro_x.R
import kotlinx.coroutines.*


class Home : AppCompatActivity() {

    var TAG = "app-debug"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        CoroutineScope(Dispatchers.IO).launch {
                getResultDateSet(this@Home.applicationContext)
                println("debug : the createDataSET funtion is running on" + Thread.currentThread().name)

            }

    }
    private fun getResultDateSet(context: Context) {

        Log.d(TAG, "createDateSet: ENTERED")
        val requestData = RequestJson()
        println("debug: launching job1: ${Thread.currentThread().name}")
        val output = requestData.fetchApi(context)
        println("value of the response : \n $output")
    }

}

