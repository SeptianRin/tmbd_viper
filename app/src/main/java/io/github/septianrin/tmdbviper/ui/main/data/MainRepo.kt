package io.github.septianrin.tmdbviper.ui.main.data

import io.github.septianrin.tmdbviper.entity.Joke
import io.github.septianrin.tmdbviper.ui.main.MainContract
import io.github.septianrin.tmdbviper.ui.main.api.MainApi
import retrofit2.Call

class MainRepo(private val api : MainApi): MainContract.Repo {
    
    override fun getUser(): Call<List<Joke>> {
        return api.getData()
    }

}