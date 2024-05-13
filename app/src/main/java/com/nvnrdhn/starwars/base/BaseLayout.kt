package com.nvnrdhn.starwars.base

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun BaseLayout_Preview() {
    val vm = object : BaseVM() {}

    vm.loading = true
    vm.error = Exception("Error message")

    BaseLayout(vm) {
        BasicText(text = "Hello, World!")
    }
}

@Composable
fun BaseLayout(
    vm: BaseVM,
    content: @Composable () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        when {
            vm.loading -> CircularProgressIndicator()
            vm.error != null -> BasicText(text = "Error: ${vm.error?.message}")
            else -> content()
        }
    }
}