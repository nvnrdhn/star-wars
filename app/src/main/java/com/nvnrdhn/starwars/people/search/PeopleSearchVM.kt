package com.nvnrdhn.starwars.people.search

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.nvnrdhn.starwars.base.BaseVM
import com.nvnrdhn.starwars.datamodel.PeopleModel
import com.nvnrdhn.starwars.repo.PeopleSearchRepo

class PeopleSearchVM(private val repo: PeopleSearchRepo) : BaseVM() {

    var peopleList = mutableStateListOf<PeopleModel>()
    var currentPage by mutableIntStateOf(1)
    var paginationLoading by mutableStateOf(false)
    var maxCount = 0

    fun init() {
        loading = true
        loadPeopleList()
    }

    fun loadPeopleList() {
        launchSafely {
            repo.getPeopleList(currentPage)
                .collect {
                    maxCount = it.count
                    peopleList.addAll(it.results)
                    loading = false
                    paginationLoading = false
                }
        }
    }

    fun loadNextPage() {
        if (paginationLoading || peopleList.size >= maxCount) return
        paginationLoading = true
        currentPage++
        loadPeopleList()
    }
}