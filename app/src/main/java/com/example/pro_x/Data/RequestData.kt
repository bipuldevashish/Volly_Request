package com.example.pro_x.Data

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.json.JSONException
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine


class RequestData {

    var TAG = "app-debug-requestdata"

     suspend fun fetchApi(context : Context) {

        Log.d(TAG, "fetchWallpaper: Entered")
        val queue = Volley.newRequestQueue(context)
        val url = "https://api.pexels.com/v1/curated/?page=1&per_page=80"
        val fetchWallpaperLink = FetchWallpaperLink()
        val stringRequest = object : StringRequest(
                Request.Method.GET,
                url,
                Response.Listener<String> { response ->

                    try {

                        fetchWallpaperLink.getWallpaper(response)

                    }catch (e : JSONException){
                        Toast.makeText(context, "response, " + response.toString() + "", Toast.LENGTH_SHORT).show()
                        e.printStackTrace()
                    }
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