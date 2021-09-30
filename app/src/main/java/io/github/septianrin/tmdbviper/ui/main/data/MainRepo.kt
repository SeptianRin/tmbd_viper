package io.github.septianrin.tmdbviper.ui.main.data

import io.github.septianrin.tmdbviper.entity.Joke
import io.github.septianrin.tmdbviper.ui.main.MainContract
import io.github.septianrin.tmdbviper.ui.main.api.MainApi
import io.github.septianrin.tmdbviper.ui.main.api.NetworkConfig
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class MainRepo(private val networkConfig: NetworkConfig): MainContract.Repo {

    override fun getUser(): Observable<List<Joke>> {
        val service = networkConfig.retrofitInstance.create(MainApi::class.java)
        val call = service.getData()
        return call
    }


}