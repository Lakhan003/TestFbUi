package com.app.fbuitestapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.fbuitestapp.adapter.PostAdapter
import com.app.fbuitestapp.databeans.PostItem
import com.app.fbuitestapp.dialog.CommentDialog
import com.app.fbuitestapp.utility.ReadLocalJson
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        postRecycle.layoutManager = LinearLayoutManager(this)
        postRecycle.adapter = PostAdapter(ReadLocalJson.readJSON(this)) {
            val bundle = Bundle()
            bundle.putSerializable("POST_ITEM", it)
            val commentDialog = CommentDialog.newInstance(bundle)
            commentDialog.show(supportFragmentManager, "Comments")
        }
    }
}