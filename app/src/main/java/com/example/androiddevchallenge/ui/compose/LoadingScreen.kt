package com.example.androiddevchallenge.ui.compose

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.example.androiddevchallenge.ui.Loading

@Composable
internal fun LoadingScreen(state: Loading) {
    Surface(color = MaterialTheme.colors.background) {
        DropdownButton(selectedCity = state.selectedCity, onClick = { })
        DropdownMenu()
    }
}