package com.example.pro_x.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.pro_x.Model.ImageListModel
import com.example.pro_x.R


class StaggeredRecyclerViewAdapter(var context: Context, var arrayList: ArrayList<ImageListModel>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
        val itemHolder = LayoutInflater.from(parent.context).inflate(R.layout.layout_list_item, parent, false)
        return ItemHolder(itemHolder)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")

        return arrayList.size
    }

    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var imageThumbnail : ImageView = itemView.findViewById<ImageView>(R.id.item_photo_iv)
    }
}