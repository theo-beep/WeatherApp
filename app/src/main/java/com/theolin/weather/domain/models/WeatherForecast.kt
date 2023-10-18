package com.theolin.weather.domain.models

import java.time.LocalDateTime

data class WeatherForecast(
    val weatherDataPerDay: Map<Int, List<WeatherForecastDaily>>,
    val currentWeatherData: WeatherForecastDaily?
)

data class WeatherForecastDaily(
    val time: LocalDateTime,
    val temperatureCelsius: Double,
    val pressure: Double,
    val windSpeed: Double,
    val humidity: Double,
    val weatherType: WeatherConditions
)
