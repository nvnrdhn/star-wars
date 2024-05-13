package com.nvnrdhn.starwars.repo

import com.nvnrdhn.starwars.datamodel.PaginationModel
import com.nvnrdhn.starwars.datamodel.PeopleModel
import kotlinx.coroutines.flow.Flow


interface PeopleSearchRepo {
    fun getPeopleList(page: Int): Flow<PaginationModel<PeopleModel>>
}