package io.github.septianrin.tmdbviper.ui.main.api

import io.github.septianrin.tmdbviper.entity.Joke
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface MainApi {
    @GET("api/random")
    fun getData(): Observable<List<Joke>>

}