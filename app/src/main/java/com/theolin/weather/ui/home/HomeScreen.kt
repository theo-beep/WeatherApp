/*
 * Copyright (C) 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.theolin.weather.ui.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.theolin.weather.ui.components.CurrentDayComponent
import com.theolin.weather.ui.components.DailyHourForecast
import com.theolin.weather.ui.theme.DefaultBrush
import com.theolin.weather.ui.theme.gradientCloudy
import com.theolin.weather.ui.theme.gradientRainy
import com.theolin.weather.ui.theme.gradientSunny

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen(modifier: Modifier = Modifier, viewModel: HomeViewModel = hiltViewModel()) {

    val state by viewModel.state.collectAsStateWithLifecycle()

    //TODO add placeholder image for icon
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = state.weather?.currentWeatherData?.weatherType?.background ?: DefaultBrush
            )

    ) {

        if (state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        } else if (!state.error.isNullOrBlank()) {
            //TODO Compose error component
        } else {
            Column(
                modifier = Modifier.verticalScroll(rememberScrollState())
            ) {
                state.weather?.currentWeatherData.let {
                    CurrentDayComponent(
                        temperature = it?.temperatureCelsius.toString(),
                        description = it?.weatherType?.description.orEmpty(),
                        pressure = it?.pressure.toString(),
                        windSpeed = it?.windSpeed.toString(),
                        humidity = it?.humidity.toString(),
                        iconRes = it?.weatherType?.iconRes
                            ?: androidx.core.R.drawable.ic_call_answer
                    )
                }

                DailyHourForecast(state = state, index = 0)
                DailyHourForecast(state = state, index = 1)
                DailyHourForecast(state = state, index = 2)
                DailyHourForecast(state = state, index = 3)
                DailyHourForecast(state = state, index = 4)
                DailyHourForecast(state = state, index = 5)
                DailyHourForecast(state = state, index = 6)
                DailyHourForecast(state = state, index = 7)
            }
        }
    }
}