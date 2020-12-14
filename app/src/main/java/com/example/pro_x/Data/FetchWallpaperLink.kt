package com.example.pro_x.Data

import android.content.ContentValues.TAG
import android.util.Log
import com.example.pro_x.Adapter.StaggeredRecyclerViewAdapter
import com.example.pro_x.Model.ImageListModel
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class FetchWallpaperLink {


    val list = ArrayList<ImageListModel>()

    fun getWallpaper(response: String) : ArrayList<ImageListModel> {

        try {
            val jsonObject = JSONObject(response)
            val jsonArray: JSONArray = jsonObject.getJSONArray("photos")
            val lenth: Int = jsonArray.length()
            Log.d(TAG, "fetchWallpaper: " + "length of the jsonarray is :" + lenth)






            //iterating through the json array
//            for (i in 0 until jsonArray.length()) {
//                var jsonObject: JSONObject = jsonArray.getJSONObject(i)
//                var id: Int = jsonObject.getInt("id")
//                var objectImage: JSONObject = jsonObject.getJSONObject("src")
//                var largeImageUrl: String = objectImage.getString("large")
//                var mediumImageUrl: String = objectImage.getString("medium")
//
//                val imageListModel = ImageListModel(id, mediumImageUrl, largeImageUrl)
//                imagearrayList.add(imageListModel)
//            }




            var staggeredRecyclerViewAdapter = StaggeredRecyclerViewAdapter()
            staggeredRecyclerViewAdapter.notifyDataSetChanged()

        } catch (e: JSONException) {
        }
        Log.d(TAG, "getWallpaper: ")
        return list
    }

    fun convertJsonToBlogPosts(jsonArray: JSONArray): ArrayList<ImageListModel>{

        for(i in 0 until jsonArray.length()){
            list.add(
                    ImageListModel(
                            (jsonArray[i] as JSONObject)["id"] as Int,
                            (jsonArray[i] as JSONObject)["mediumUrl"] as String,
                            (jsonArray[i] as JSONObject)["largeUrl"] as String
                    )
            )
        }
        return list
    }


}