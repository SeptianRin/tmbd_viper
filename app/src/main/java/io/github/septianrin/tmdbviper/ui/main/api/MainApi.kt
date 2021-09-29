package io.github.septianrin.tmdbviper.ui.main.api


import io.github.septianrin.tmdbviper.entity.Joke
import retrofit2.Call
import retrofit2.http.GET

interface MainApi {
    @GET("api/random")
    fun getData(): Call<List<Joke>>


}