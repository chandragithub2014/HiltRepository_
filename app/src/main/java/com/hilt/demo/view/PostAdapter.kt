package com.hilt.demo.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hilt.demo.R
import com.hilt.demo.model.PostModel
import kotlinx.android.synthetic.main.item_layout.view.*

class PostAdapter(var postList : ArrayList<PostModel>) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PostViewHolder(LayoutInflater.from(parent.context).inflate(
        R.layout.item_layout , parent  , false))

    override fun getItemCount(): Int  = postList.size


    override fun onBindViewHolder(holder: PostAdapter.PostViewHolder, position: Int)  =  holder.bind(postList[position])

     fun refreshAdapter(newPostList : List<PostModel>){
        postList.clear()
        postList.addAll(newPostList)
        notifyDataSetChanged()

    }

    inner class PostViewHolder(view : View) : RecyclerView.ViewHolder(view){
       private val layout =  view.post_layout
       private val  user_id = view.userid_val
        private  val id = view.id_val
        private val title = view.title_val
        fun  bind(model : PostModel){
            user_id.text = model.id.toString()
            id.text = model.userId.toString()
            title.text = model.title
        }

    }

}