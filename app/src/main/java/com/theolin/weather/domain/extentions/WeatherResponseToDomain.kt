package com.theolin.weather.domain.extentions

import android.os.Build
import androidx.annotation.RequiresApi
import com.theolin.weather.data.network.ForecastResponse
import com.theolin.weather.domain.models.WeatherConditions
import com.theolin.weather.domain.models.WeatherForecastDaily
import java.time.LocalDateTime

import java.time.format.DateTimeFormatter

/**
 * extension function to do mapping to convert our response into a domain object
 *
 * **see also** [ Kotlin extension functions ](https://kotlinlang.org/docs/extensions.html)
 */

private data class IndexedWeatherData(
    val index: Int,
    val data: WeatherForecastDaily
)

@RequiresApi(Build.VERSION_CODES.O)
fun ForecastResponse.toDomain(): Map<Int, List<WeatherForecastDaily>> {
    return hourly?.time?.mapIndexed { index, time ->
        val temperature = hourly.temperature2m?.get(index)
        val weatherCode = hourly.weathercode?.get(index)
        val windSpeed = hourly.windspeed10m?.get(index)
        val pressure = hourly.pressureMsl?.get(index)
        val humidity = hourly.relativehumidity2m?.get(index)
        IndexedWeatherData(
            index = index,
            data = WeatherForecastDaily(
                time = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME),
                temperatureCelsius = temperature,
                pressure = pressure,
                windSpeed = windSpeed,
                humidity = humidity?.toDouble(),
                weatherType = WeatherConditions.fromWMO(weatherCode)
            )
        )
    }?.groupBy {
        it.index / 24
    }?.mapValues {
        it.value.map { it.data }
    } ?: emptyMap()
}

@RequiresApi(Build.VERSION_CODES.O)
fun Map<Int, List<WeatherForecastDaily>>.toCurrentWeatherInfo(): WeatherForecastDaily? {
    val now = LocalDateTime.now()
    val currentWeatherData = this[0]?.find {
        val hour = if (now.minute < 30) now.hour else now.hour + 1
        it.time?.hour == hour
    }
    return currentWeatherData
}