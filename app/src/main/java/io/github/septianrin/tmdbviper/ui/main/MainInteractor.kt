package io.github.septianrin.tmdbviper.ui.main

import io.github.septianrin.tmdbviper.entity.Joke
import io.github.septianrin.tmdbviper.ui.main.data.MainRepo

class MainInteractor(repo: MainRepo) : MainContract.Interactor {
    val listJoke : List<Joke> = repo.getUser()!!

    override fun getUsers(): List<Joke>? {
        return listJoke
    }


}