package com.chathuranga.retrofit_test_assigment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ListView
import androidx.navigation.fragment.findNavController
import com.example.ouk.Post
import com.example.ouk.PostAdapter
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val geson = GsonBuilder().create();
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create(geson))
            .build()

        val postAPI = retrofit.create(PostApi::class.java)
        val postCall = postAPI.posts
        postCall.enqueue(object : Callback<List<Post>> {
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Log.d("MainActivity2", t.message.toString())
            }

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                val listView = view.findViewById<ListView>(R.id.ListView)
                val adapter = PostAdapter(requireActivity(), response.body() as ArrayList<Post>)
                listView.adapter = adapter
                Log.d("MainActivity2", "Success")
            }
        })
    }
}