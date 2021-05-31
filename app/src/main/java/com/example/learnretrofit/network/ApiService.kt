package com.example.learnretrofit.network

import com.example.learnretrofit.BasePokemon
import retrofit2.Call
import retrofit2.http.GET


interface ApiService{
    //Get Data Pokemon
    @GET("pokemon")
    fun getContentList() : Call<BasePokemon>
}

