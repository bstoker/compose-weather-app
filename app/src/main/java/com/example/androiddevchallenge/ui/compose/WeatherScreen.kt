package com.example.androiddevchallenge.ui.compose

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.domain.Condition
import com.example.androiddevchallenge.domain.Weather
import com.example.androiddevchallenge.domain.Wind
import com.example.androiddevchallenge.ui.DisplayWeather
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
internal fun WeatherScreen(state: DisplayWeather) {
    Surface(color = MaterialTheme.colors.background) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                painter = painterResource(id = R.drawable.ic_wb_sunny_black),
                contentDescription = "weather icon",
            )
            Row() {
                Icon(
                    painter = painterResource(id = R.drawable.ic_thermostat),
                    contentDescription = "temperature"
                )
                Text(text = "36C")
            }
            DropdownButton(selectedCity = state.selectedCity, onClick = { showBottomSheet() })
        }
    }
}

private fun showBottomSheet() {
    // TODO
}

@Composable
fun DropdownMenu() {
    val expanded = remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.TopStart)
    ) {
        Row {
            Text(text = "Amsterdam")
            IconButton(onClick = { expanded.value = true }) {
                Icon(Icons.Default.MoreVert, contentDescription = "Localized description")
            }
        }
        DropdownMenu(
            expanded = expanded.value,
            onDismissRequest = { expanded.value = false }
        ) {
            DropdownMenuItem(onClick = { /* Handle refresh! */ }) {
                Text("Amsterdam")
            }
            DropdownMenuItem(onClick = { /* Handle settings! */ }) {
                Text("Settings")
            }
            Divider()
            DropdownMenuItem(onClick = { /* Handle send feedback! */ }) {
                Text("Send Feedback")
            }
        }
    }
}

private val state = DisplayWeather(
    cities = listOf("Amsterdam", "Rotterdam"),
    selectedCity = "Amsterdam",
    currentWeather = Weather(
        conditions = listOf(
            Condition(
                name = "Clear",
                description = "clear sky",
                iconUrl = "url",
            )
        ),
        humidity = 42f,
        temperature = 15f,
        wind = Wind(direction = 90, speed = 8f),
    ),
)

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
private fun LightPreview() {
    MyTheme {
        WeatherScreen(state)
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
private fun DarkPreview() {
    MyTheme(darkTheme = true) {
        WeatherScreen(state)
    }
}
