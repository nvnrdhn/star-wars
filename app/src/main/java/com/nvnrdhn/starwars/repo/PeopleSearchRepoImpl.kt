package com.nvnrdhn.starwars.repo

import com.nvnrdhn.starwars.datamodel.PaginationModel
import com.nvnrdhn.starwars.datamodel.PeopleModel
import com.nvnrdhn.starwars.service.PeopleSearchApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PeopleSearchRepoImpl @Inject constructor(
    private val apiService: PeopleSearchApiService
) : PeopleSearchRepo {
    override fun getPeopleList(page: Int): Flow<PaginationModel<PeopleModel>> = flow {
        emit(apiService.getPeopleList(page))
    }
}