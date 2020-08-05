package com.hilt.demo.model

import androidx.recyclerview.widget.DiffUtil

data class PostModel(
    val userId:Int,
    val id : Int,
    val title : String,
    val completed: Boolean
)
class DiffUtilPostsModelItem: DiffUtil.ItemCallback<PostModel>() {
    override fun areItemsTheSame(
        oldItem: PostModel,
        newItem: PostModel
    ): Boolean {
        return newItem.id == oldItem.id
    }

    override fun areContentsTheSame(
        oldItem: PostModel,
        newItem: PostModel
    ): Boolean {
        return newItem == oldItem
    }
}