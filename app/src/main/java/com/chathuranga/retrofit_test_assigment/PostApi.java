package com.chathuranga.retrofit_test_assigment;

import com.example.ouk.Post;import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostApi {
    @GET("/Posts")
    Call<List<Post>> getPosts();
}
