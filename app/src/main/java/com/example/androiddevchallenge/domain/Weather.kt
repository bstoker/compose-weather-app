package com.example.androiddevchallenge.domain

data class Weather(
    val conditions: List<Condition>,
    val humidity: Float,
    val temperature: Float,
    val wind: Wind,
)

data class Condition(
    val name: String,
    val description: String,
    val iconUrl: String,
)

data class Wind(
    val direction: Int,
    val speed: Float,
)