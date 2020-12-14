package com.example.pro_x.Data

import android.content.Context
import android.util.Log
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley


class RequestData {

    var TAG = "app-debug-requestdata"
    private lateinit var apiResponse : String
    fun fetchApi(context : Context) : String {

        Log.d(TAG, "fetchWallpaper: Entered")
        val queue = Volley.newRequestQueue(context)
        val url = "https://api.pexels.com/v1/curated/?page=1&per_page=80"
        val stringRequest = object : StringRequest(
                Method.GET,
                url,
                Response.Listener { response ->
                    println(response)
                    apiResponse = response
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
        return apiResponse
    }
}