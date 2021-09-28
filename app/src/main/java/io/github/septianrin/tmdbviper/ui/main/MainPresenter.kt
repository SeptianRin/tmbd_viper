package io.github.septianrin.tmdbviper.ui.main
import io.github.septianrin.tmdbviper.entity.User

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
        val data: List<User> = interactor.getUsers()!!
        view?.publishData(data)
        view?.hideLoading()
    }

    override fun onItemClicked(user: User) {
        router.openDetailUser(user)
    }

    override fun onBackClicked() {
        router.finish()
    }
}