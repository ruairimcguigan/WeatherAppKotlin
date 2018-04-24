package com.weather.kotlin.data.models

data class Forecast (val dt: Long, val temp: Temperature, val pressure: Float,
                     val humidity: Int, val weather: List<Weather>,
                     val speed: Float, val deg: Int, val clouds: Int,
                     val rain: Float)