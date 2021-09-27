package io.github.septianrin.tmdbviper.ui.splash

interface SplashContract {
    interface View

    interface Presenter{
        fun bindView(view : View)
        fun unbindView()
        fun onViewCreated()

    }
    interface Router{
        fun openMainActivity()
    }
}