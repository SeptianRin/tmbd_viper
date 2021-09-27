package io.github.septianrin.tmdbviper.ui.main

import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import io.github.septianrin.tmdbviper.databinding.ActivityMainBinding
import io.github.septianrin.tmdbviper.entity.User
import io.github.septianrin.tmdbviper.ui.main.adapter.MainAdapter
import io.github.septianrin.tmdbviper.ui.main.api.MainApi
import io.github.septianrin.tmdbviper.ui.main.data.MainRepo

class MainActivity : AppCompatActivity(), MainContract.View {

    private lateinit var binding: ActivityMainBinding

    private val presenter: MainPresenter = MainPresenter(MainRouter(this),
        MainInteractor(MainRepo(MainApi()))
    )

    companion object {
        fun launch(context: Context) {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initView()
        presenter.bindView(this)
        presenter.onViewCreated()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unbindView()
    }

    private fun initView() {
        val manager = LinearLayoutManager(this).apply { orientation = LinearLayoutManager.VERTICAL }
        binding.recyclerView.layoutManager = manager
        binding.toolbar1.toolbar.title = "Title"
        binding.toolbar1.toolbar.setTitleTextColor(ContextCompat.getColor(this, android.R.color.white))
        binding.toolbar1.toolbar.setNavigationOnClickListener { presenter.onBackClicked() }
    }

    override fun showLoading() {
        binding.recyclerView.visibility = View.VISIBLE
        binding.progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        binding.recyclerView.visibility = View.INVISIBLE
        binding.progressBar.visibility = View.INVISIBLE
    }

    override fun publishData(data: List<User>) {
        Log.e(TAG, "publishData: a" )
        val adapter = MainAdapter(data, object : MainAdapter.UserListener {
            override fun onItemClick(user: User) {
                presenter.onItemClicked(user)
            }
        })
        binding.recyclerView.adapter = adapter

    }

    override fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

}