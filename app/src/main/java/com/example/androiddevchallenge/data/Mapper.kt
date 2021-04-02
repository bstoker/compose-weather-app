package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.domain.Condition
import com.example.androiddevchallenge.domain.Weather
import com.example.androiddevchallenge.domain.WeatherForecast
import com.example.androiddevchallenge.domain.Wind
import com.example.androiddevchallenge.data.Wind as WindJson
import com.example.androiddevchallenge.data.Weather as WeatherJson
import com.example.androiddevchallenge.data.WeatherForecast as WeatherForecastJson
import com.example.androiddevchallenge.data.CurrentWeather as CurrentWeatherJson

internal fun CurrentWeatherJson.toWeather() = Weather(
    conditions = weather.map { it.toCondition() },
    humidity = main.humidity,
    temperature = main.temp,
    wind = wind.toWind(),
)

internal fun WeatherForecastJson.toWeatherForecast() = WeatherForecast(
    dailyForecast = list.map { it.toWeather() }
)

private fun WeatherForecastItem.toWeather() = Weather(
    conditions = weather.map { it.toCondition() },
    humidity = humidity,
    temperature = temp.day,
    wind = Wind(
        direction = deg,
        speed = speed,
    ),
)

private fun WeatherJson.toCondition() = Condition(
    name = main,
    description = description,
    iconUrl = icon,
)

private fun WindJson.toWind() = Wind(
    direction = deg,
    speed = speed,
)