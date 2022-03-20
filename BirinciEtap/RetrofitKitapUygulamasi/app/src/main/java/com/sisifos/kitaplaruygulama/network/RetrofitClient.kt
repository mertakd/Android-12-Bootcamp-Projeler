package com.sisifos.kitaplaruygulama.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    //webs servis oluşturuyoruz
    companion object{
        fun  getClient(baseUrl: String) : Retrofit{
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}