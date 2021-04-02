package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Query

internal interface WeatherService {

    @GET("/data/2.5/forecast/daily?appid=$API_KEY&units=metric")
    suspend fun getWeatherForecast(
        @Query("q") city: String,
        @Query("cnt") days: Int = MAX_DAYS,
    ): WeatherForecast

    @GET("/data/2.5/weather?appid=$API_KEY&units=metric")
    suspend fun getCurrentWeather(@Query("q") city: String): CurrentWeather

    companion object {
        private const val API_KEY = BuildConfig.OPEN_WEATHER_MAP_API_KEY
        private const val MAX_DAYS = 7
    }
}