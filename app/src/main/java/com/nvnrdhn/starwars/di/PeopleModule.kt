package com.nvnrdhn.starwars.di

import com.nvnrdhn.starwars.repo.PeopleSearchRepo
import com.nvnrdhn.starwars.repo.PeopleSearchRepoImpl
import com.nvnrdhn.starwars.service.PeopleSearchApiService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit
import retrofit2.create

@Module
@InstallIn(ViewModelComponent::class)
abstract class PeopleModule {

    companion object {
        @Provides
        fun providePeopleSearchApiService(retrofit: Retrofit): PeopleSearchApiService {
            return retrofit.create()
        }
    }

    @Binds
    abstract fun bindPeopleSearchRepo(peopleSearchRepoImpl: PeopleSearchRepoImpl): PeopleSearchRepo
}