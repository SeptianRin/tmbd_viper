package io.github.septianrin.tmdbviper.ui.detail

import io.github.septianrin.tmdbviper.entity.MovieEntity

interface DetailContract {
    interface View{
        fun publishData(movie: MovieEntity)

        fun showMessage(msg: Int)

    }

    interface Presenter{
        fun bindView(view:View)
        fun unbindView()
        fun onViewCreated(movie: MovieEntity)
        fun onBackClicked()
        fun onEmptyData(msg: Int)

    }

    interface Router{
        fun finish()
    }
}