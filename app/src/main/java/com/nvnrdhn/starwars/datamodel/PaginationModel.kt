package com.nvnrdhn.starwars.datamodel

data class PaginationModel<T>(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<T>
)