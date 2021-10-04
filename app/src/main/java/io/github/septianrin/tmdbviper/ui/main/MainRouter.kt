package io.github.septianrin.tmdbviper.ui.main

import io.github.septianrin.tmdbviper.entity.MovieEntity
import io.github.septianrin.tmdbviper.ui.detail.DetailActivity

class MainRouter(private val activity: MainActivity): MainContract.Router {
    override fun finish() {
        activity.finish()
    }

    override fun openDetailUser(data: MovieEntity) {
        DetailActivity.launch(activity, data)
    }

}