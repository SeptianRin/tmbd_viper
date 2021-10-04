package io.github.septianrin.tmdbviper.ui.detail

import io.github.septianrin.tmdbviper.entity.MovieEntity

class DetailPresenter(private val router: DetailContract.Router): DetailContract.Presenter {

    private var view: DetailContract.View? = null
    override fun bindView(view: DetailContract.View) {
        this.view = view
    }

    override fun unbindView() {
        view = null
    }

    override fun onViewCreated(movie: MovieEntity) {
        view?.publishData(movie)
    }

    override fun onBackClicked() {
        router.finish()
    }

    override fun onEmptyData(msg: Int) {
        view?.showMessage(msg)
        router.finish()
    }

}