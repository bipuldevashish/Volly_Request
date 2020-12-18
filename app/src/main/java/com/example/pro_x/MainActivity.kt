package com.example.pro_x

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.pro_x.Adapter.StaggeredRecyclerViewAdapter
import com.example.pro_x.Data.RequestData
import kotlinx.coroutines.*


class MainActivity : AppCompatActivity() {

    lateinit var recyclerAdapter: StaggeredRecyclerViewAdapter
    var TAG = "app-debug"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
        CoroutineScope(Dispatchers.IO).launch {
                getResultDateSet(this@MainActivity.applicationContext)
                println("debug : the createDataSET funtion is running on" + Thread.currentThread().name)

            }

    }
    private suspend fun getResultDateSet(context: Context) {

                 Log.d(TAG, "createDateSet: ENTERED")
                 val requestData = RequestData()
                 println("debug: launching job1: ${Thread.currentThread().name}")
                 val output = requestData.fetchApi(context)
                 println("value of the response : \n $output")

             }

    private fun initRecyclerView( ) {
        val recyclerView : RecyclerView = findViewById(R.id.recycler_View)
        recyclerView.apply {
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            recyclerAdapter = StaggeredRecyclerViewAdapter()
            adapter = recyclerAdapter
        }
    }

}

