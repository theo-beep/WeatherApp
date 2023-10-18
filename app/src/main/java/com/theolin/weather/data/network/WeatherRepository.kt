package com.theolin.weather.data.network

import com.theolin.weather.common.DataResource
import javax.inject.Inject

interface WeatherRepository {
    suspend fun getWeatherForecast(
        latitude: Double,
        longitude: Double
    ): DataResource<ForecastResponse>
}

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
) : WeatherRepository {
    override suspend fun getWeatherForecast(
        latitude: Double,
        longitude: Double
    ): DataResource<ForecastResponse> {
        return try {
            DataResource.Success(
                data = api.getWeatherData(lat = latitude, long = longitude)
            )
        } catch (e: Exception) {
            e.printStackTrace()
            DataResource.Error(
                message = e.stackTraceToString()
            )
        }
    }
}