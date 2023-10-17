package com.theolin.weather.data.network

import javax.inject.Inject

interface WeatherRepository {
    suspend fun getWeatherForecast(
        latitude: Double,
        longitude: Double
    ): ForecastResponse
}

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
) : WeatherRepository {
    override suspend fun getWeatherForecast(
        latitude: Double,
        longitude: Double
    ): ForecastResponse {
        return api.getWeatherData(lat = latitude, long = longitude)
    }
}