package com.nvnrdhn.starwars

import android.app.Application
import com.nvnrdhn.starwars.di.BaseDependencies
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class StarWarsApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        initDependencies()
    }

    private fun initDependencies() {
        startKoin {
            androidContext(this@StarWarsApplication)
            modules(BaseDependencies.networkModule)
        }
    }
}