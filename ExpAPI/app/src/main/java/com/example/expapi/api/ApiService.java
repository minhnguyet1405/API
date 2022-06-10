package com.example.expapi.api;

import com.example.expapi.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
   // https://jsonplaceholder.typicode.com/users?fbclid=IwAR3JlQt-nnp4iDdQzDV6mGYMtmWbE81KK3YP8krBpvm3eLea1ZpWGLlHYVs

    Gson gson= new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();

    ApiService apiService =new Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);

    @GET("users")
    Call<List<User>> listUser();

}
