package io.github.septianrin.tmdbviper.ui.main
import io.github.septianrin.tmdbviper.entity.Joke
import io.github.septianrin.tmdbviper.ui.main.data.MainRepo

class MainInteractor(private val api: MainRepo) : MainContract.Interactor{
    override fun getUsers(onComplete: (MutableList<Joke>)-> Unit) {
        api.getUser{list->
            onComplete.invoke(list)
        }
    }
}
