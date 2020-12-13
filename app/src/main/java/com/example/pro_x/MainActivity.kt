package com.example.pro_x

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.pro_x.Adapter.StaggeredRecyclerViewAdapter
import com.example.pro_x.Data.RequestData
import com.example.pro_x.Model.ImageListModel
import kotlinx.coroutines.*


class MainActivity : AppCompatActivity() {

    private lateinit var staggeredRecyclerViewAdapter: StaggeredRecyclerViewAdapter
    var TAG = "app-debug"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initRecyclerView()
        CoroutineScope(Dispatchers.IO).launch {
            createDateSet(this@MainActivity)
            delay(1000)
       }

    }
    suspend fun createDateSet(context: Context) {
        Log.d(TAG, "createDateSet: ENTERED")
        val data : ArrayList<ImageListModel>  = RequestData.fetchApi(context)
        staggeredRecyclerViewAdapter.submitList(data)
    }

    fun initRecyclerView() {
        Log.d(TAG, "initRecyclerView: Entered")
        var recyclerView: RecyclerView = findViewById(R.id.recycler_View)
        recyclerView.apply {
            layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
            val topSpacingItemDecoration = TopSpacingItemDecoration(30)
            addItemDecoration(topSpacingItemDecoration)
            staggeredRecyclerViewAdapter = StaggeredRecyclerViewAdapter()
            adapter = staggeredRecyclerViewAdapter
        }
    }

}

