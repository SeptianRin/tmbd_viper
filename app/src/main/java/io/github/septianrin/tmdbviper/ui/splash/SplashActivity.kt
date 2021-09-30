package io.github.septianrin.tmdbviper.ui.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.github.septianrin.tmdbviper.R

class SplashActivity : AppCompatActivity(), SplashContract.View {

    var router: SplashRouter = SplashRouter(this)

    private var presenter: SplashPresenter = SplashPresenter(router)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        presenter.bindView(this)
        presenter.onViewCreated()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unbindView()
    }

}