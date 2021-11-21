package com.app.fbuitestapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.fbuitestapp.R
import com.app.fbuitestapp.viewholder.CommonViewHolder
import kotlinx.android.synthetic.main.item_comment.view.*

class CommentAdapter(private val commentList: List<String>) :
    RecyclerView.Adapter<CommonViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommonViewHolder {
        return CommonViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_comment, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CommonViewHolder, position: Int) {
        with(holder.itemView) {
            txtComment.text = commentList[position]
        }
    }

    override fun getItemCount(): Int {
        return commentList.count()
    }
}