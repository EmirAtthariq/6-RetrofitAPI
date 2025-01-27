package com.motion.jokes

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

// interface for APICALL
interface ChuckNorrisApi {
    // Get request
    @GET("jokes/random")
    // function that pass category as parameter
    // and return an ChuckNorrisJoke Object
    fun getRandomJoke(@Query("category") category:String): Call<ChuckNorrisJoke>
}