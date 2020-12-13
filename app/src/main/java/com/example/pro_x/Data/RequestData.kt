package com.example.pro_x.Data

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.pro_x.Model.ImageListModel

object RequestData {

    var TAG = "app-debug-requestdata"

     fun fetchApi(context : Context) {

        Log.d(TAG, "fetchWallpaper: Entered")
        val queue = Volley.newRequestQueue(context)
        val url = "https://api.pexels.com/v1/curated/?page=1&per_page=80"
        val stringRequest = object : StringRequest(
            Request.Method.GET,
            url,
            Response.Listener<String> { response ->
                println(response)
                val fetchWallpaperLink = FetchWallpaperLink()
                fetchWallpaperLink.getWallpaper(response)
            },
            Response.ErrorListener { })

        //Authenticating yourself for the api call
        {
            override fun getHeaders(): MutableMap<String, String> {
                val headers = HashMap<String, String>()
                headers["Authorization"] = "563492ad6f917000010000018bc38c66a1bc4522bbe044d69a19e744"
                Log.d(TAG, "getHeaders: header return")
                return headers
            }
        }
        queue.add(stringRequest)
    }
}