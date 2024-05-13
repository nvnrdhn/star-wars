package com.nvnrdhn.starwars.di

import com.nvnrdhn.starwars.people.search.PeopleSearchVM
import com.nvnrdhn.starwars.repo.PeopleSearchRepo
import com.nvnrdhn.starwars.repo.PeopleSearchRepoImpl
import com.nvnrdhn.starwars.service.PeopleSearchApiService
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.create

object PeopleDependencies {
    fun init() {
        loadKoinModules(peopleModule)
    }

    private val peopleModule = module {
        viewModel { PeopleSearchVM(get()) }

        single<PeopleSearchRepo> { PeopleSearchRepoImpl(get()) }

        single { providePeopleSearchApiService(get()) }
    }

    private fun providePeopleSearchApiService(retrofit: Retrofit): PeopleSearchApiService =
        retrofit.create()
}