package com.example.pro_x

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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

    fun fetchWallpaper(){

        val queue = Volley.newRequestQueue(this)
        val url = "https://api.pexels.com/v1/curated/?page=1&per_page=80"
        var request = object : StringRequest(Request.Method.GET, url, Response.Listener<String> {

        response ->
            run {
                try {
                    val jsonObject: JSONObject = JSONObject(response)
                    val jsonArray: JSONArray = jsonObject.getJSONArray("id")
                    val length: Int = jsonArray.length()
                    Log.d("value", "value of array length =" + length)
                } catch (e: JSONException) {

                }

            }

        }, Response.ErrorListener() {
        })

        {
            override fun getParams(): MutableMap<String, String> {
                val header = HashMap<String, String>()
                header.put("Authorization","563492ad6f917000010000018bc38c66a1bc4522bbe044d69a19e744")
                return header
            }
        }

        queue.add(request)
            }
        }

