package com.example.pro_x.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.pro_x.Model.ImageListModel
import com.example.pro_x.R


class StaggeredRecyclerViewAdapter :
        RecyclerView.Adapter<StaggeredRecyclerViewAdapter.ItemHolder>() {

    private var imageList: List<ImageListModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {

        return ItemHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_list_item, parent, false))
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(imageList.get(position))
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    fun submitList(dataList : List<ImageListModel>){
        imageList = dataList
    }

    class ItemHolder
        constructor(v: View) : RecyclerView.ViewHolder(v),View.OnClickListener {

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

        override fun onClick(p0: View?) {
            TODO("Not yet implemented")
            }
        }
    }