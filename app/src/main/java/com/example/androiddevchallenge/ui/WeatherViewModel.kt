package com.example.androiddevchallenge.ui

import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.domain.WeatherRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*

internal class WeatherViewModel(
    private val weatherRepository: WeatherRepository,
) : ViewModel() {

    private val city = MutableStateFlow("Amsterdam")

    private val cities = listOf(
        "Amsterdam",
        "Berlin",
        "Brussels",
        "London",
        "Madrid",
        "Paris",
        "Rotterdam",
        "The Hague",
        "Utrecht",
        "Vienna",
    )

    val initialState = Loading(cities = cities, selectedCity = city.value)

    @ExperimentalCoroutinesApi
    val viewState: Flow<ViewState> = city
        .filterNot { it.isEmpty() }
        .mapLatest { city ->
            DisplayWeather(
                cities = cities,
                selectedCity = city,
                currentWeather = weatherRepository.getCurrentWeather(city),
            ) as ViewState
        }
        .flowOn(Dispatchers.Default)

    fun setCity(city: String) {
        this.city.value = city
    }

}