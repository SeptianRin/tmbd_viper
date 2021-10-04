package io.github.septianrin.tmdbviper.ui.main

import io.github.septianrin.tmdbviper.entity.ApiResponse
import io.github.septianrin.tmdbviper.entity.MovieEntity
import io.reactivex.rxjava3.core.Observable

interface MainContract {

    interface View{
        fun showLoading()
        fun hideLoading()
        fun publishData(data: List<MovieEntity>)
        fun showMessage(msg: String)
    }

    interface Presenter{
        fun bindView(view: View)
        fun unbindView()
        fun onViewCreated()
        fun onItemClicked(movie: MovieEntity)
        fun onBackClicked()
    }

    interface Interactor{
        fun getUsers(onComplete: (List<MovieEntity>) -> Unit)
    }

    interface Router{
        fun finish()
        fun openDetailUser(data: MovieEntity)
    }

    interface Repo{
        fun getUser(): Observable<ApiResponse>
    }
}