package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.domain.WeatherRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

internal class DefaultWeatherRepository(
    private val weatherService: WeatherService
) : WeatherRepository {

    override suspend fun getCurrentWeather(city: String) = withContext(Dispatchers.IO) {
        weatherService.getCurrentWeather(city).toWeather()
    }

    override suspend fun getWeatherForecast(city: String) = withContext(Dispatchers.IO) {
        weatherService.getWeatherForecast(city).toWeatherForecast()
    }
}