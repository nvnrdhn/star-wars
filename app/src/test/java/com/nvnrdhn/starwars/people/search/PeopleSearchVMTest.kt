package com.nvnrdhn.starwars.people.search

import com.nvnrdhn.starwars.TestDispatcherRule
import com.nvnrdhn.starwars.datamodel.PaginationModel
import com.nvnrdhn.starwars.datamodel.PeopleModel
import com.nvnrdhn.starwars.repo.PeopleSearchRepo
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.mockk
import kotlinx.coroutines.flow.flow
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class PeopleSearchVMTest {

    @get:Rule
    val testDispatcherRule = TestDispatcherRule()

    @InjectMockKs
    private lateinit var vm: PeopleSearchVM

    private val repo: PeopleSearchRepo = mockk(relaxed = true)

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `should load next page correctly when pagination is not loading and people list is less than max count`() {
        val mockResponse = PaginationModel<PeopleModel>(
            count = 10,
            results = listOf(mockk(), mockk(), mockk()),
            next = "",
            previous = ""
        )

        vm.paginationLoading = false
        vm.peopleList.addAll(listOf(mockk(), mockk(), mockk()))
        vm.maxCount = 10

        every { repo.getPeopleList(any()) } returns flow { emit(mockResponse) }

        vm.loadNextPage()

        assertEquals(2, vm.currentPage)
        assertEquals(6, vm.peopleList.size)
    }
}