package com.example.pro_x.Data

import android.content.Context
import android.nfc.Tag
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.pro_x.Adapter.StaggeredRecyclerViewAdapter
import com.example.pro_x.Model.ImageListModel
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

object RequestData {

    var TAG = "app-debug-requestdata"

     fun fetchWallpaper(context : Context) : ArrayList<ImageListModel> {

        Log.d(TAG, "fetchWallpaper: Entered")
        var imagearrayList = ArrayList<ImageListModel>()
        val queue = Volley.newRequestQueue(context)
        val url = "https://api.pexels.com/v1/curated/?page=1&per_page=80"
        val stringRequest = object : StringRequest(
            Request.Method.GET,
            url,
            Response.Listener<String> { response ->
                println(response)
                try {
                    val jsonObject = JSONObject(response)
                    val jsonArray: JSONArray = jsonObject.getJSONArray("photos")
                    val lenth: Int = jsonArray.length()
                    Log.d(TAG, "fetchWallpaper: " + "length of the jsonarray is :" + lenth)

                    //iterating through the json array
                    for (i in 0 until jsonArray.length()) {
                        var jsonObject: JSONObject = jsonArray.getJSONObject(i)
                        var id: Int = jsonObject.getInt("id")
                        var objectImage: JSONObject = jsonObject.getJSONObject("src")
                        var largeImageUrl: String = objectImage.getString("large")
                        var mediumImageUrl: String = objectImage.getString("medium")

                        val imageListModel = ImageListModel(id, mediumImageUrl, largeImageUrl)
                        imagearrayList.add(imageListModel)
                    }


                    Log.d(TAG, "fetchWallpaper: after the for loop " + imagearrayList.size)
                    var staggeredRecyclerViewAdapter = StaggeredRecyclerViewAdapter()
                    staggeredRecyclerViewAdapter.notifyDataSetChanged()

                } catch (e: JSONException) {
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
        Log.d(TAG, "fetchWallpaper: " + "size of the imagearraylist before returning" + imagearrayList.size)
        return imagearrayList
    }
}