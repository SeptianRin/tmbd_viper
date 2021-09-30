package io.github.septianrin.tmdbviper.ui.main.api


import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class NetworkConfig {
    lateinit var retrofit: Retrofit
    private val baseurl = "https://umorili.herokuapp.com/"

    val retrofitInstance: Retrofit
    get() {
        if (!this::retrofit.isInitialized){
            val headerInterceptor = Interceptor{ chain ->
                val requestBuilder = chain.request().newBuilder()
                chain.proceed(requestBuilder.build())
            }
            val okHttpClient = OkHttpClient()
                .newBuilder()
                .followRedirects(true)
                .addInterceptor(headerInterceptor)
                .build()
            retrofit = Retrofit.Builder()
                .baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .client(okHttpClient)
                .build()
        }
        return retrofit
    }
}