package io.github.septianrin.tmdbviper.ui.main.api

import android.util.Log
import io.github.septianrin.tmdbviper.entity.User

class MainApi {
    fun getAllUser() : List<User>? {
        var userList : MutableList<User>? = arrayListOf()
        userList?.add(User(1,"halo1","halo1","dia ini halo1"))
        userList?.add(User(2,"halo2","halo2","dia ini halo2"))
        userList?.add(User(3,"halo3","halo3","dia ini halo3"))
        userList?.add(User(4,"halo4","halo4","dia ini halo4"))
        userList?.add(User(5,"halo5","halo5","dia ini halo5"))
        userList?.add(User(6,"halo6","halo6","dia ini halo6"))
        userList?.add(User(7,"halo7","halo7","dia ini halo7"))
        return userList?.toList()
    }
}