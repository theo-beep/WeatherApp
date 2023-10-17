package com.theolin.weather.data.network


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
/**
 * Generated serializable class for api calls
 *
 * **See Also:** [Json To Kotlin plugin on jetbrains marketplace ](https://plugins.jetbrains.com/plugin/9960-json-to-kotlin-class-jsontokotlinclass-)
 */
@Serializable
data class ForecastResponse(
    @SerialName("elevation")
    val elevation: Double?,
    @SerialName("generationtime_ms")
    val generationtimeMs: Double?,
    @SerialName("hourly")
    val hourly: Hourly?,
    @SerialName("hourly_units")
    val hourlyUnits: HourlyUnits?,
    @SerialName("latitude")
    val latitude: Double?,
    @SerialName("longitude")
    val longitude: Double?,
    @SerialName("timezone")
    val timezone: String?,
    @SerialName("timezone_abbreviation")
    val timezoneAbbreviation: String?,
    @SerialName("utc_offset_seconds")
    val utcOffsetSeconds: Int?
) {
    @Serializable
    data class Hourly(
        @SerialName("temperature_2m")
        val temperature2m: List<Double?>?,
        @SerialName("time")
        val time: List<String?>?
    )

    @Serializable
    data class HourlyUnits(
        @SerialName("temperature_2m")
        val temperature2m: String?,
        @SerialName("time")
        val time: String?
    )
}