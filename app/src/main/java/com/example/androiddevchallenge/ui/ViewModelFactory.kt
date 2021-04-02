package com.example.androiddevchallenge.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androiddevchallenge.domain.WeatherRepository
import java.lang.IllegalStateException

class ViewModelFactory(
    private val weatherRepository: WeatherRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(WeatherViewModel::class.java) -> WeatherViewModel(weatherRepository)
            else -> throw IllegalStateException("Cannot create view model for ${modelClass.simpleName}")
        } as T
}