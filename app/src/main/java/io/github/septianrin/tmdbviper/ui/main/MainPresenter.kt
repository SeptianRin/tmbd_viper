package io.github.septianrin.tmdbviper.ui.main
import io.github.septianrin.tmdbviper.entity.MovieEntity

class MainPresenter(private val router: MainRouter, private val interactor: MainInteractor ): MainContract.Presenter {

    private var view :MainContract.View? = null


    override fun bindView(view: MainContract.View) {
        this.view = view
    }

    override fun unbindView() {
        view = null
    }

    override fun onViewCreated() {
        view?.showLoading()
        interactor.getUsers {
            list-> view?.publishData(list)
        }
        view?.hideLoading()
    }

    override fun onItemClicked(movie: MovieEntity) {
        router.openDetailUser(movie)
    }

    override fun onBackClicked() {
        router.finish()
    }

}