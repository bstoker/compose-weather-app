package com.example.androiddevchallenge.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun DropdownButton(selectedCity: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(16.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier.background(Color.Transparent),
        ) {
            Text(text = selectedCity)
            Icon(
                imageVector = Icons.Default.ChevronRight,
                contentDescription = "Favorite Icon",
                modifier = Modifier.padding(end = 8.dp)
            )
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
private fun LightPreview() {
    MyTheme {
        DropdownButton(selectedCity = "Amsterdam") {

        }
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
private fun DarkPreview() {
    MyTheme(darkTheme = true) {
        DropdownButton(selectedCity = "Amsterdam") {

        }
    }
}