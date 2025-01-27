package com.motion.jokes

import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiCall {
    // Define a function called "getRandomJoke" that takes a
    // category string and a callback function as input
    fun getRandomJoke(category:String, callback: (ChuckNorrisJoke?) -> Unit) {
        // Create a Retrofit instance with base URL, an
        // OkHttpClient instance, and a Gson converter factory
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.chucknorris.io/")
            .client(OkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        // Create an instance of the ChuckNorrisApi interface
        // using the Retrofit instance
        val api = retrofit.create(ChuckNorrisApi::class.java)

        // Make an asynchronous API call to get a random Chuck Norris
        // joke with the given category using the "getRandomJoke"
        // function of the ChuckNorrisApi interface
        api.getRandomJoke(category).enqueue(object : Callback<ChuckNorrisJoke> {
            // it define the code that execute if response is received
            override fun onResponse(call: Call<ChuckNorrisJoke>, response: Response<ChuckNorrisJoke>) {

                if (response.isSuccessful) {
                    val joke : ChuckNorrisJoke? = response.body()
                    callback(joke)
                }
                // If the response is not successful,
                // pass null to the callback function
                else {
                    callback(null)
                }
            }

            // when the API call fails
            override fun onFailure(call: Call<ChuckNorrisJoke>, t: Throwable) {
                // Pass null to the callback function
                callback(null)
            }
        })
    }
}