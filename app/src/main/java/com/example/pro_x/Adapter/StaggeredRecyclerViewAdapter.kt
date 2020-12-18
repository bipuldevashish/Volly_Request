package com.example.pro_x.Adapter

import android.content.Context
import android.media.Image
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.pro_x.Model.ImageListModel
import com.example.pro_x.R


class StaggeredRecyclerViewAdapter :
        RecyclerView.Adapter<StaggeredRecyclerViewAdapter.ItemHolder>() {

    private var TAG = "ADAPTER"
    private var imageList : List<ImageListModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {

        return ItemHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_list_item, parent, false))
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(imageList.get(position))
    }

    override fun getItemCount(): Int {
        println("size of imagelist inside getItemCount : ${imageList.size}")
        println("debug : adapter is running on" + Thread.currentThread().name)
        return imageList.size
    }

    fun submitList(dataList: List<ImageListModel>){
        this.imageList = dataList
        Log.d(TAG, " Inside submitList: value of the imagelist : ${imageList.size}")
        notifyDataSetChanged()
    }

    class ItemHolder
    constructor(v: View) : RecyclerView.ViewHolder(v) {

        fun bind(imageListModel: ImageListModel){
            val imageView : ImageView = itemView.findViewById(R.id.item_photo_iv)
            val requestOptions = RequestOptions()
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                    .applyDefaultRequestOptions(requestOptions)
                    .load(imageListModel.mediumUrl)
                    .into(imageView)

        }
    }
}
