package com.example.pro_x.Data

import android.content.Context
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.pro_x.Model.ImageListModel
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

object RequestData {

        fun fetchWallpaper(context : Context) {

        var imagearrayList = arrayListOf<String>()
        val queue = Volley.newRequestQueue(context)
        val url = "https://api.pexels.com/v1/curated/?page=1&per_page=80"
        val stringRequest = object : StringRequest(Request.Method.GET, url, Response.Listener<String> { response ->

            try {
                val jsonObject = JSONObject(response)
                val jsonArray: JSONArray = jsonObject.getJSONArray("photos")
                val lenth: Int = jsonArray.length()
                println("length of the jsonarray is :" + lenth)

                //iterating through the json array
                for (i in 0 until jsonArray.length()) {
                    var jsonObject : JSONObject = jsonArray.getJSONObject(i)
                    var id : Int = jsonObject.getInt("id")
                    var objectImage : JSONObject = jsonObject.getJSONObject("src")
                    var largeImageUrl : String = objectImage.getString("large")
                    var mediumImageUrl : String = objectImage.getString("medium")


                    val imageListModel = ImageListModel(id, mediumImageUrl, largeImageUrl)
                    imagearrayList.add(imageListModel.toString())


                }
            } catch (e: JSONException) {
            }

        }, Response.ErrorListener { })

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