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
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.theolin.weather.common.DataResource
import com.theolin.weather.domain.models.WeatherForecast
import com.theolin.weather.domain.usecase.GetWeatherForecastUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@RequiresApi(Build.VERSION_CODES.O)
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val weatherUseCase: GetWeatherForecastUseCase
) : ViewModel() {


    private val _state: MutableStateFlow<WeatherState> = MutableStateFlow(WeatherState())
    val state: StateFlow<WeatherState> = _state

    init {
        getWeatherForecast()
    }

    private fun getWeatherForecast() {
        viewModelScope.launch {
            weatherUseCase.invoke(lat = 52.52, long = 13.41).collect { result ->
                _state.value =
                    when (result) {
                        is DataResource.Success -> WeatherState(
                            weather = result.data,
                            isLoading = true
                        )
                        is DataResource.Error -> WeatherState(error = result.message)
                        is DataResource.Loading -> WeatherState(isLoading = true)
                    }
            }
        }
    }

}

data class WeatherState(
    val weather: WeatherForecast? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
