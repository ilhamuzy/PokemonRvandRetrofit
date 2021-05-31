package com.example.learnretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.learnretrofit.network.ApiClient
import com.example.learnretrofit.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    var listAdapter : ListAdapterPokemon? = null
    var heroes = ArrayList<ResultPokemon>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.rvPokemon)


        ApiClient.instances.getContentList().enqueue(object : Callback<BasePokemon>{
            override fun onResponse(call: Call<BasePokemon>, response: Response<BasePokemon>) {
                if (response.isSuccessful){
//                    Log.d("dataResponse", response.body()?.next.toString())
                    heroes = response.body()?.result as ArrayList<ResultPokemon>
                    listAdapter =ListAdapterPokemon(heroes)
                    recyclerView.adapter = listAdapter
                    recyclerView.layoutManager = GridLayoutManager(this@MainActivity, 2)
                    recyclerView.setHasFixedSize(true)
                }
            }

            override fun onFailure(call: Call<BasePokemon>, t: Throwable) {
                Log.d("errorResponse", t.localizedMessage)
            }

        })



    }

}

