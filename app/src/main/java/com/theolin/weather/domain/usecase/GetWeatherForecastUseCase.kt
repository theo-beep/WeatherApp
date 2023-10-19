package com.theolin.weather.domain.usecase

import android.os.Build
import androidx.annotation.RequiresApi
import com.theolin.weather.common.DataResource
import com.theolin.weather.data.network.WeatherRepository
import com.theolin.weather.domain.extentions.toCurrentWeatherInfo
import com.theolin.weather.domain.extentions.toDomain
import com.theolin.weather.domain.models.WeatherForecast
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetWeatherForecastUseCase @Inject constructor(
    private val repository: WeatherRepository
) {
    @RequiresApi(Build.VERSION_CODES.O)
    operator fun invoke(lat: Double, long: Double): Flow<DataResource<WeatherForecast>> = flow {
        try {
            emit(DataResource.Loading())
            val weather =
                repository.getWeatherForecast(latitude = lat, longitude = long).data?.toDomain()
            emit(
                DataResource.Success(
                    WeatherForecast(
                        weatherDataPerDay = weather,
                        currentWeatherData = weather?.toCurrentWeatherInfo()
                    )
                )
            )
        } catch (e: HttpException) {
            emit(DataResource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(DataResource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}