package com.nvnrdhn.starwars.repo

import com.nvnrdhn.starwars.datamodel.PaginationModel
import com.nvnrdhn.starwars.datamodel.PeopleModel
import com.nvnrdhn.starwars.service.PeopleSearchApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PeopleSearchRepoImpl(private val apiService: PeopleSearchApiService) : PeopleSearchRepo {
    override fun getPeopleList(page: Int): Flow<PaginationModel<PeopleModel>> = flow {
        emit(apiService.getPeopleList(page))
    }
}