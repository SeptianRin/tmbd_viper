package io.github.septianrin.tmdbviper.ui.detail

import io.github.septianrin.tmdbviper.entity.User

interface DetailContract {
    interface View{
        fun publishData(user: User)

        fun showMessage(msg: Int)

    }

    interface Presenter{
        fun bindView(view:View)
        fun unbindView()
        fun onViewCreated(data: User)
        fun onBackClicked()
        fun onEmptyData(msg: Int)

    }

    interface Router{
        fun finish()
    }
}