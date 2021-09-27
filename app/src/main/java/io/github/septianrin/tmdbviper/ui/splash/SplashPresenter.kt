package io.github.septianrin.tmdbviper.ui.splash

import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit

class SplashPresenter(private val router: SplashContract.Router): SplashContract.Presenter {


    companion object{
        private const val SPLASH_DISPLAY_TIME = 2L
    }
    private var view: SplashContract.View? = null

    override fun bindView(view: SplashContract.View) {
        this.view = view

    }

    override fun unbindView() {
        view = null
    }

    override fun onViewCreated() {
        val backgroundExecutor: ScheduledExecutorService = Executors.newSingleThreadScheduledExecutor()
        backgroundExecutor.schedule({
            router.openMainActivity()
        }, SPLASH_DISPLAY_TIME, TimeUnit.SECONDS)
        backgroundExecutor.shutdown()
    }
}