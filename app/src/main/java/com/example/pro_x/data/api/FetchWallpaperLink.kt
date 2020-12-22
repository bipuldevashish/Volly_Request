package com.example.pro_x.data.api

import android.content.ContentValues.TAG
import android.util.Log
import com.example.pro_x.model.ImageListModel
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class FetchWallpaperLink {


    val list = ArrayList<ImageListModel>()

    fun getWallpaper(response: String) {

        try {
            val jsonObject = JSONObject(response)
            val jsonArray: JSONArray = jsonObject.getJSONArray("photos")
            val length: Int = jsonArray.length()
            Log.d(TAG, "fetchWallpaper: length of the jsonarray is :$length")


            //iterating through the json array
            for (i in 0 until jsonArray.length()) {
                var jsonObject: JSONObject = jsonArray.getJSONObject(i)
                val id: Int = jsonObject.getInt("id")
                val objectImage: JSONObject = jsonObject.getJSONObject("src")
                val largeImageUrl: String = objectImage.getString("large")
                val mediumImageUrl: String = objectImage.getString("medium")

                val imageListModel = ImageListModel(id, mediumImageUrl, largeImageUrl)
                list.add(imageListModel)
            }

        } catch (e: JSONException) {
        }

        println("value of list before calling submitlist() : ${list.size}")
    }
}
