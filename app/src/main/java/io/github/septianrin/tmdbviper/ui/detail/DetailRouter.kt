package io.github.septianrin.tmdbviper.ui.detail

class DetailRouter(private val activity: DetailActivity): DetailContract.Router {
    override fun finish() {
        activity.finish()
    }
}