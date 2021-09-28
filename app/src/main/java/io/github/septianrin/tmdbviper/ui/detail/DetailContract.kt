package io.github.septianrin.tmdbviper.ui.detail

import io.github.septianrin.tmdbviper.entity.Joke

interface DetailContract {
    interface View{
        fun publishData(joke: Joke)

        fun showMessage(msg: Int)

    }

    interface Presenter{
        fun bindView(view:View)
        fun unbindView()
        fun onViewCreated(data: Joke)
        fun onBackClicked()
        fun onEmptyData(msg: Int)

    }

    interface Router{
        fun finish()
    }
}