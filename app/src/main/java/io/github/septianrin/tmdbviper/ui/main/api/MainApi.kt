package io.github.septianrin.tmdbviper.ui.main.api

import io.github.septianrin.tmdbviper.entity.ApiResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface MainApi {

    @GET("movie/popular?api_key=85336489ee63ee8418e461b427ace0ce")
    fun getData(): Observable<ApiResponse>

}