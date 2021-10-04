package io.github.septianrin.tmdbviper.ui.main.data

import io.github.septianrin.tmdbviper.entity.ApiResponse
import io.github.septianrin.tmdbviper.ui.main.MainContract
import io.github.septianrin.tmdbviper.ui.main.api.MainApi
import io.github.septianrin.tmdbviper.ui.main.api.NetworkConfig
import io.reactivex.rxjava3.core.Observable

class MainRepo(private val networkConfig: NetworkConfig): MainContract.Repo {

    override fun getUser(): Observable<ApiResponse> {
        val service = networkConfig.retrofitInstance.create(MainApi::class.java)
        val call = service.getData()
        return call
    }


}