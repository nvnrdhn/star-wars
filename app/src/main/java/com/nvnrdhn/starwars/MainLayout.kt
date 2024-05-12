package com.nvnrdhn.starwars

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun MainLayout_Preview() {
    MainLayout()
}

@Composable
fun MainLayout() {
    Row {
        BasicText(text = "Hello, World!")
    }
}