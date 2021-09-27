package io.github.septianrin.tmdbviper.ui.main

import io.github.septianrin.tmdbviper.entity.User
import io.github.septianrin.tmdbviper.ui.main.data.MainRepo

interface MainContract {

    interface View{
        fun showLoading()
        fun hideLoading()
        fun publishData(data: List<User>)
        fun showMessage(msg: String)
    }

    interface Presenter{
        fun bindView(view: View)
        fun unbindView()
        fun onViewCreated()
        fun onItemClicked(user: User)
        fun onBackClicked()
    }

    interface Interactor{
        fun getUsers(): List<User>?
    }

    interface Router{
        fun finish()
        fun openDetailUser(data: User)
    }

    interface Repo{
        fun getUser(): List<User>?
    }
}