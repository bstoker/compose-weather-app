package com.example.androiddevchallenge.ui

import com.example.androiddevchallenge.domain.Weather

internal interface ViewState

data class Loading(
    val cities: List<String>,
    val selectedCity: String,
) : ViewState

data class DisplayWeather(
    val cities: List<String>,
    val selectedCity: String,
    val currentWeather: Weather,
) : ViewState