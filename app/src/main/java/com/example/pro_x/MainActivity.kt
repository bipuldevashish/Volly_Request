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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    private lateinit var staggeredRecyclerViewAdapter: StaggeredRecyclerViewAdapter
    var TAG = "app-debug"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initRecyclerView()
        GlobalScope.launch {
            createDateSet(this@MainActivity)
            delay(3000)
        }

    }
    suspend fun createDateSet(context: Context) {
        Log.d(TAG, "createDateSet: ENTERED")
        val data = RequestData.fetchWallpaper(context)
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

