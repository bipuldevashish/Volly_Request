package com.example.pro_x.data.api

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException


class RequestJson {

    var TAG = "app-debug-requestdata"
     fun fetchApi(context : Context) {

        Log.d(TAG, "fetchWallpaper: Entered")
        val queue = Volley.newRequestQueue(context)
        val url = "https://api.pexels.com/v1/curated/?page=1&per_page=80" // api request url
        val fetchWallpaperLink = FetchWallpaperLink() //object declaration


        val stringRequest = object : StringRequest(
                Request.Method.GET,
                url,
                Response.Listener<String> { response ->

                    try {

                        fetchWallpaperLink.getWallpaper(response)

                    }catch (e : JSONException){
                        Toast.makeText(context, "response, $response", Toast.LENGTH_SHORT).show()
                        e.printStackTrace()
                    }
                },
                Response.ErrorListener { })

        //Authenticating yourself for the api call
        {
            override fun getHeaders(): MutableMap<String, String> {
                val headers = HashMap<String, String>()
                headers["Authorization"] = "Insert your API KEY"
                Log.d(TAG, "getHeaders: header return")
                return headers
            }
        }

        queue.add(stringRequest)
    }
}