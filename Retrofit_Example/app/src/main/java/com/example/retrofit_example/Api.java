package com.example.retrofit_example;

import android.icu.text.IDNA;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    String BASE_URL = "https://jsonplaceholder.typicode.com/posts";

    @GET("posts")
    Call<List<Information>> getInfo();
}
