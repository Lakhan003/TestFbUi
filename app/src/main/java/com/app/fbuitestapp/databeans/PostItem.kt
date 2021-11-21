package com.app.fbuitestapp.databeans

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import java.io.Serializable


class PostItem : Serializable {
    @SerializedName("post")
    @Expose
    val post: String? = null

    @SerializedName("comments")
    @Expose
    val comments: List<String>? = null
}