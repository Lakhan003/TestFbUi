package com.app.fbuitestapp.utility

import android.content.Context
import com.app.fbuitestapp.databeans.PostItem
import com.google.gson.Gson
import org.json.JSONArray
import java.io.IOException
import java.io.InputStream

object ReadLocalJson {
    fun readJSON(context: Context): ArrayList<PostItem> {
        val postList = ArrayList<PostItem>()
        try {
            val gson = Gson()
            val inputStream: InputStream = context.assets.open("data.json")
            val size: Int = inputStream.available()
            val buffer = ByteArray(size)
            // read values in the byte array
            inputStream.read(buffer)
            inputStream.close()
            // convert byte to string
            val json = JSONArray(String(buffer, Charsets.UTF_8))
            for (i in 0 until json.length()) {
                postList.add(
                    gson.fromJson(
                        json.getJSONObject(i).toString(),
                        PostItem::class.java
                    )
                )
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return postList
    }
}