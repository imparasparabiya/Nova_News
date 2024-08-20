package com.example.novanews.Client

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsAPIClient {
    companion object {

        val BASE_URL = "https://google-news13.p.rapidapi.com/"
        var retrofit: Retrofit? = null

        fun getNewsAPIClient(): Retrofit? {
            retrofit = Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build()

            return retrofit
        }
    }
}