package com.example.novanews.Interface

import com.example.novanews.Modal.PopularModal
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPIInterface {

    @GET("latest?")
        fun getPopular(
        @Query("country") country: String,
        @Query("apikey") key: String = "7c004458f9msh2b5c388a12ceb7bp168904jsne5941ab6d4ad"):retrofit2.Call<PopularModal>




}