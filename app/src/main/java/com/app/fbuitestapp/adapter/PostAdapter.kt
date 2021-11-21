package com.app.fbuitestapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.fbuitestapp.R
import com.app.fbuitestapp.databeans.PostItem
import com.app.fbuitestapp.viewholder.CommonViewHolder
import kotlinx.android.synthetic.main.item_post.view.*

class PostAdapter(
    private val listOfPosts: ArrayList<PostItem>,
    private val onItemClick: (postItem: PostItem) -> Unit
) :
    RecyclerView.Adapter<CommonViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommonViewHolder {
        return CommonViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CommonViewHolder, position: Int) {
        with(holder.itemView) {
            val postItem = listOfPosts[position]
            txtPost.text = postItem.post
            commentCount.text =
                if (postItem.comments != null) {
                    "${
                        postItem.comments.count()
                    } Comments"
                } else {
                    "0 Comments"
                }
            setOnClickListener { onItemClick(postItem) }
        }
    }

    override fun getItemCount(): Int {
        return listOfPosts.count()
    }
}