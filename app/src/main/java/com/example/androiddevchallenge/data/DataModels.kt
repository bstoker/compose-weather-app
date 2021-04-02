package com.example.androiddevchallenge.data

import com.google.gson.annotations.SerializedName

internal data class WeatherForecast(
    val city: City,
    val cod: Int,
    val message: Float,
    val cnt: Int,
    val list: List<WeatherForecastItem>
)

internal data class CurrentWeather(
    val coord: Coordinates,
    val weather: List<Weather>,
    val base: String,
    val main: Main,
    val visibility: Int,
    val wind: Wind,
    val clouds: Clouds,
    val rain: Rain,
    val snow: Snow,
    val dt: Long,
    val sys: Sys,
    val timezone: Long,
    val id: Int,
    val name: String,
    val cod: Int
)

internal data class WeatherForecastItem(
    val dt: Long,
    val sunrise: Long,
    val sunset: Long,
    val temp: Temperatures,
    val feels_like: FeelsLike,
    val pressure: Float,
    val humidity: Float,
    val weather: List<Weather>,
    val speed: Float,
    val deg: Int,
    val clouds: Int,
    val pop: Float,
)

internal data class City(
    val id: Int,
    val name: String,
    val coord: Coordinates,
    val country: String,
    val population: Int,
    val timezone: Long,
)

internal data class Coordinates(
    val lon: String,
    val lat: String,
)

internal data class Weather(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String,
)

internal data class Main(
    val temp: Float,
    val feels_like: Float,
    val temp_min: Float,
    val temp_max: Float,
    val pressure: Float,
    val humidity: Float,
)

internal data class Temperatures(
    val day: Float,
    val min: Float,
    val max: Float,
    val night: Float,
    val eve: Float,
    val morn: Float,
)

internal data class FeelsLike(
    val day: Float,
    val night: Float,
    val eve: Float,
    val morn: Float,
)

internal data class Wind(
    val speed: Float,
    val deg: Int,
)

internal data class Clouds(
    val all: Int,
)

internal data class Rain(
    @SerializedName("1h") val precipitationIn1HourInMm: Int,
    @SerializedName("3h") val precipitationIn3HoursInMm: Int,
)

internal data class Snow(
    @SerializedName("1h") val precipitationIn1HourInMm: Int,
    @SerializedName("3h") val precipitationIn3HoursInMm: Int,
)

internal data class Sys(
    val type: Int,
    val id: Int,
    val message: Float,
    val country: String,
    val sunrise: Long,
    val sunset: Long,
)