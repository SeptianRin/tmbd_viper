package io.github.septianrin.tmdbviper.ui.main

import android.content.ContentValues.TAG
import android.util.Log
import io.github.septianrin.tmdbviper.entity.User
import io.github.septianrin.tmdbviper.ui.main.data.MainRepo

class MainInteractor(repo: MainRepo) : MainContract.Interactor {
    val listUser : List<User> = repo.getUser()!!

    override fun getUsers(): List<User>? {
        return listUser
    }


}