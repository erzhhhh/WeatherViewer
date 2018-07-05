package com.example.erzhena.weather.di.modules

import android.content.Context
import android.util.Log
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [
    WeatherModule::class
])

open class AppModule(private val context: Context, private val baseUrl: String) {

    @Singleton
    @Provides
    fun provideGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideRxJavaCallAdapterFactory(): RxJava2CallAdapterFactory {
        return RxJava2CallAdapterFactory.create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient, converterFactory: GsonConverterFactory, adapterFactory: RxJava2CallAdapterFactory): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(converterFactory)
            .addCallAdapterFactory(adapterFactory)
            .client(client)
            .build()
    }

    @Singleton
    @Provides
    fun provideHTTPLoggingInterceptor() : HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor{
            msg -> Log.d("okhttp",msg)
        }
        interceptor.level = HttpLoggingInterceptor.Level.HEADERS
        return interceptor
    }


    @Provides
    @Singleton
    fun provideContext(): Context {
        return context
    }
}