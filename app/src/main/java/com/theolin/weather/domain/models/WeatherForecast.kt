package com.theolin.weather.domain.models

data class WeatherForecast(
    val elevation: Double?,
    val generationtimeMs: Double?,
    val hourly: HourlyDomain,
    val hourlyUnits: HourlyUnitsDomain,
    val latitude: Double?,
    val longitude: Double?,
    val timezone: String?,
    val timezoneAbbreviation: String?,
    val utcOffsetSeconds: Int?
)

data class HourlyDomain(
    val temperature2m: List<Double?>?,
    val time: List<String?>?
)

data class HourlyUnitsDomain(
    val temperature2m: String?,
    val time: String?
)