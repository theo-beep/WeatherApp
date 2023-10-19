package com.theolin.weather.ui.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.theolin.weather.R
import com.theolin.weather.ui.home.WeatherState

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DailyHourForecast(
    state: WeatherState,
    index : Int ,
) {
    state.weather?.weatherDataPerDay?.get(index)?.let { data ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = data.get(0).time?.dayOfWeek.toString(),
                fontSize = 20.sp,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(16.dp))
            LazyRow(content = {
                items(data) { weatherData ->
                    //TODO get a placeholder image
                    HourForecastComponent(
                        time = weatherData.time?.hour.toString()+":00",
                        icon = weatherData.weatherType?.iconRes ?: R.drawable.ic_pressure,
                        temperature = weatherData.temperatureCelsius.toString()
                    )

                }
            })
        }
    }
}