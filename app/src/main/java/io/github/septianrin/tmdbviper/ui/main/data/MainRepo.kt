package io.github.septianrin.tmdbviper.ui.main.data

import android.util.Log
import io.github.septianrin.tmdbviper.entity.User
import io.github.septianrin.tmdbviper.ui.main.MainContract
import io.github.septianrin.tmdbviper.ui.main.api.MainApi

class MainRepo(private val api : MainApi): MainContract.Repo {
    
    override fun getUser(): List<User>? {
        return api.getAllUser()
    }

}