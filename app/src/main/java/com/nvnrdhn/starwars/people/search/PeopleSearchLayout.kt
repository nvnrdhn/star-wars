package com.nvnrdhn.starwars.people.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.nvnrdhn.starwars.base.BaseLayout
import com.nvnrdhn.starwars.datamodel.PeopleModel
import org.koin.androidx.compose.koinViewModel


@Preview
@Composable
fun PeopleSearchLayout_Preview() {
    PeopleItemLayout(PeopleModel("Test"))
}

@Composable
fun PeopleSearchLayout(
    vm: PeopleSearchVM = koinViewModel()
) {
    val lazyListState = rememberLazyListState()

    vm.init()

    BaseLayout(vm = vm) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(8.dp),
            state = lazyListState
        ) {
            items(vm.peopleList) {
                PeopleItemLayout(it)
            }
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun PeopleItemLayout(
    item: PeopleModel
) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            GlideImage(model = "https://placehold.co/80x80.png", contentDescription = "")
            BasicText(text = item.name)
        }
    }
}