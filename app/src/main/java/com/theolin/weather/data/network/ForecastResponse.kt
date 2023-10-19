package com.theolin.weather.data.network


import com.google.gson.annotations.SerializedName

data class ForecastResponse(
    @SerializedName("elevation")
    val elevation: Double?,
    @SerializedName("generationtime_ms")
    val generationtimeMs: Double?,
    @SerializedName("hourly")
    val hourly: Hourly?,
    @SerializedName("hourly_units")
    val hourlyUnits: HourlyUnits?,
    @SerializedName("latitude")
    val latitude: Double?,
    @SerializedName("longitude")
    val longitude: Double?,
    @SerializedName("timezone")
    val timezone: String?,
    @SerializedName("timezone_abbreviation")
    val timezoneAbbreviation: String?,
    @SerializedName("utc_offset_seconds")
    val utcOffsetSeconds: Int?
) {
    data class Hourly(
        @SerializedName("pressure_msl")
        val pressureMsl: List<Double?>?,
        @SerializedName("relativehumidity_2m")
        val relativehumidity2m: List<Int?>?,
        @SerializedName("temperature_2m")
        val temperature2m: List<Double?>?,
        @SerializedName("time")
        val time: List<String?>?,
        @SerializedName("weathercode")
        val weathercode: List<Int?>?,
        @SerializedName("windspeed_10m")
        val windspeed10m: List<Double?>?
    )

    data class HourlyUnits(
        @SerializedName("pressure_msl")
        val pressureMsl: String?,
        @SerializedName("relativehumidity_2m")
        val relativehumidity2m: String?,
        @SerializedName("temperature_2m")
        val temperature2m: String?,
        @SerializedName("time")
        val time: String?,
        @SerializedName("weathercode")
        val weathercode: String?,
        @SerializedName("windspeed_10m")
        val windspeed10m: String?
    )
}