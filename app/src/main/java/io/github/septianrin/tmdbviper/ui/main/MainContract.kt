package io.github.septianrin.tmdbviper.ui.main

import io.github.septianrin.tmdbviper.entity.Joke

interface MainContract {

    interface View{
        fun showLoading()
        fun hideLoading()
        fun publishData(data: List<Joke>)
        fun showMessage(msg: String)
    }

    interface Presenter{
        fun bindView(view: View)
        fun unbindView()
        fun onViewCreated()
        fun onItemClicked(joke: Joke)
        fun onBackClicked()
    }

    interface Interactor{
        fun getUsers(): List<Joke>?
    }

    interface Router{
        fun finish()
        fun openDetailUser(data: Joke)
    }

    interface Repo{
        fun getUser(): List<Joke>?
    }
}