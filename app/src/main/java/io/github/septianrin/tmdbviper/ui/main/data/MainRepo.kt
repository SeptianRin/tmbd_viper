package io.github.septianrin.tmdbviper.ui.main.data

import android.content.ContentValues.TAG
import android.util.Log
import io.github.septianrin.tmdbviper.entity.Joke
import io.github.septianrin.tmdbviper.ui.main.MainContract
import io.github.septianrin.tmdbviper.ui.main.api.MainApi
import io.github.septianrin.tmdbviper.ui.main.api.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepo(private val networkConfig: NetworkConfig): MainContract.Repo {
    override fun getUser(onComplete: (MutableList<Joke>)-> Unit){
        val service = networkConfig.getRetrofitInstance()!!.create(MainApi::class.java)
        val call = service.getData()
        val data = mutableListOf<Joke>()

        call.enqueue(object : Callback<List<Joke>>{
            override fun onResponse(call: Call<List<Joke>>, response: Response<List<Joke>>) {
                if (response.isSuccessful) {
                    val users = response.body()
                    for(element in users!!){
                        data.add(element)
                    }
                    onComplete.invoke(data)
                }
            }

            override fun onFailure(call: Call<List<Joke>>, t: Throwable) {
                Log.e(TAG, "onFailure: $t" )
            }

        })
    }

}