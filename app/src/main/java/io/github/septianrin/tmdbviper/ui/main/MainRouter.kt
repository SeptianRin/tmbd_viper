package io.github.septianrin.tmdbviper.ui.main

import io.github.septianrin.tmdbviper.entity.User
import io.github.septianrin.tmdbviper.ui.detail.DetailActivity

class MainRouter(private val activity: MainActivity): MainContract.Router {
    override fun finish() {
        activity.finish()
    }

    override fun openDetailUser(data: User) {
        DetailActivity.launch(activity, data)
    }

}