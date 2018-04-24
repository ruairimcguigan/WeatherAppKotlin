package com.weather.kotlin.data.models

data class City (val id: Long, val name: String, val coord: Coordinates,
                 val country: String, val population: Int)