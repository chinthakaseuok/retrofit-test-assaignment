package com.example.ouk

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.chathuranga.retrofit_test_assigment.R

class PostAdapter(private val context: Context, private val dataSource: ArrayList<Post>): BaseAdapter() {
    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val rowView = inflater.inflate(R.layout.list_item_view, parent, false)
        val titleTextView = rowView.findViewById(R.id.title) as TextView

        val post = getItem(position) as Post
        titleTextView.text = post.title

        return rowView
    }

}