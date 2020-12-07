package com.example.pro_x

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fetchWallpaper()
    }

    fun fetchWallpaper() {

        val queue = Volley.newRequestQueue(this)
        val url = "https://api.pexels.com/v1/curated/?page=1&per_page=80"
        val stringRequest = object : StringRequest(Request.Method.GET, url, Response.Listener<String>{
            response ->
            println(response)

        },Response.ErrorListener {  })

        //Authenticating yourself for the api call
        {
            override fun getHeaders(): MutableMap<String, String> {
                val headers = HashMap<String, String>()
                headers["Authorization"] = "563492ad6f917000010000018bc38c66a1bc4522bbe044d69a19e744"
                return headers
            }
        }
        queue.add(stringRequest)
    }
}

