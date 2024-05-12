package com.nvnrdhn.starwars.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

@Preview
@Composable
fun MainLayout_Preview() {
    MainLayout()
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MainLayout() {
    Column {
        LazyColumn {
            item {
                BasicText(text = "Hello, World!")
            }

            items(10) {
                GlideImage(
                    model = "https://placehold.co/600x400/000000/FFFFFF.png",
                    contentDescription = ""
                )
            }
        }
    }
}