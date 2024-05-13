package com.nvnrdhn.starwars.service

import com.nvnrdhn.starwars.datamodel.PaginationModel
import com.nvnrdhn.starwars.datamodel.PeopleModel
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface PeopleSearchApiService {
    @GET("people")
    suspend fun getPeopleList(@Query("page") page: Int): PaginationModel<PeopleModel>
}