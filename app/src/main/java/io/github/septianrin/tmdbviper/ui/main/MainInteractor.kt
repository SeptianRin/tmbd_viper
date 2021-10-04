package io.github.septianrin.tmdbviper.ui.main
import io.github.septianrin.tmdbviper.entity.MovieEntity
import io.github.septianrin.tmdbviper.ui.main.data.MainRepo
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class MainInteractor(private val api: MainRepo) : MainContract.Interactor{
    override fun getUsers(onComplete: (List<MovieEntity>)-> Unit) {
        val compositeDisposable = CompositeDisposable()
        compositeDisposable.add(api.getUser()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe { response -> onComplete.invoke(response.results as MutableList<MovieEntity>)})
    }

}
