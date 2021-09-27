package io.github.septianrin.tmdbviper.ui.splash

import io.github.septianrin.tmdbviper.ui.main.MainActivity

class SplashRouter(private val activity: SplashActivity) : SplashContract.Router{

    override fun openMainActivity() {
        MainActivity.launch(activity)
        activity.finish()
    }
}