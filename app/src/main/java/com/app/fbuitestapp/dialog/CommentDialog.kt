package com.app.fbuitestapp.dialog

import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.fbuitestapp.R
import com.app.fbuitestapp.adapter.CommentAdapter
import com.app.fbuitestapp.databeans.PostItem
import kotlinx.android.synthetic.main.dialog_comment.*


class CommentDialog : DialogFragment(R.layout.dialog_comment) {
    companion object {
        fun newInstance(args: Bundle): CommentDialog {
            val fragment = CommentDialog()
            fragment.arguments = args
            return fragment
        }
    }

    override fun getTheme(): Int {
        return R.style.DialogFullScreen
    }
    override fun onStart() {
        if (dialog == null) {
            return
        }
        dialog!!.window!!.setWindowAnimations(
            R.style.DialogFullScreen
        )
        super.onStart()
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        eventDismiss.setOnClickListener { dismiss() }
        commentRecycle.layoutManager = LinearLayoutManager(requireContext())
        arguments?.let { it ->
            val postItem = it.getSerializable("POST_ITEM")
            postItem?.let { it1 ->
                (it1 as PostItem).comments?.let { it2 ->
                    commentRecycle.adapter = CommentAdapter(it2)
                }

            }

        }

    }
}