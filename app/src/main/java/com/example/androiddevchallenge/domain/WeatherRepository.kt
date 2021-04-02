package com.example.androiddevchallenge.domain

interface WeatherRepository {
    suspend fun getCurrentWeather(city: String): Weather
    suspend fun getWeatherForecast(city: String): WeatherForecast
}