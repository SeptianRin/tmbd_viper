package io.github.septianrin.tmdbviper.ui.detail

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.Toast
import androidx.core.content.ContextCompat
import io.github.septianrin.tmdbviper.BuildConfig
import io.github.septianrin.tmdbviper.R
import io.github.septianrin.tmdbviper.databinding.ActivityDetailBinding
import io.github.septianrin.tmdbviper.entity.Joke

class DetailActivity : AppCompatActivity(), DetailContract.View {

    companion object{
        private const val USER = "${BuildConfig.APPLICATION_ID}_USER"
        fun launch(context: Context, data: Joke) {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(USER,data)
            context.startActivity(intent)
        }
    }

    private lateinit var binding:ActivityDetailBinding

    var presenter: DetailPresenter = DetailPresenter(DetailRouter(this))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        presenter.bindView(this)
        if (intent.hasExtra(USER)){
            intent.getParcelableExtra<Joke>(USER)
            presenter.onViewCreated(intent.getParcelableExtra(USER)!!)
        }else {
            presenter.onEmptyData(R.string.app_name)
        }
    }

    private fun initView() {
        binding.toolbar.toolbar.title = this.localClassName
        binding.toolbar.toolbar.setTitleTextColor(ContextCompat.getColor(this, android.R.color.white))
        binding.toolbar.toolbar.setNavigationOnClickListener { presenter.onBackClicked() }
    }

    override fun publishData(joke: Joke) {
        binding.name.text =joke.desc
        binding.site.text = joke.site
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            binding.desc.text = Html.fromHtml(joke.elementPureHtml, Html.FROM_HTML_MODE_LEGACY)
        } else {
            binding.desc.text = (Html.fromHtml(joke.elementPureHtml))
        }
    }

    override fun showMessage(msg: Int) {
        Toast.makeText(this, "$msg", Toast.LENGTH_SHORT).show()
    }


}