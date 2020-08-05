package com.hilt.demo.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hilt.demo.R
import com.hilt.demo.model.DiffUtilPostsModelItem
import com.hilt.demo.model.PostModel
import kotlinx.android.synthetic.main.item_layout.view.*
class PostSwipeAdapter: ListAdapter<PostModel, PostSwipeAdapter.PostViewHolder>(
        DiffUtilPostsModelItem()
    ) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PostViewHolder(LayoutInflater.from(parent.context).inflate(
        R.layout.item_layout , parent  , false))

    override fun onBindViewHolder(holder: PostSwipeAdapter.PostViewHolder, position: Int)  =  holder.bind(getItem(position))



    inner class PostViewHolder(view : View) : RecyclerView.ViewHolder(view){
       private val layout =  view.post_layout
       private val  user_id = view.userid_val
        private  val id = view.id_val
        private val title = view.title_val
        fun  bind(model : PostModel){
            Log.d("PostSwipeAdapter","In bind() method.......")
            user_id.text = model.id.toString()
            id.text = model.userId.toString()
            title.text = model.title
        }

    }

}