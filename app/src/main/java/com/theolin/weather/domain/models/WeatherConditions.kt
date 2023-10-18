package com.theolin.weather.domain.models

import androidx.annotation.DrawableRes
import com.theolin.weather.R

/**
 * Sealed class to map all my svg icons into my weather condition object
 *
 * **See Also:** [Sealed classes and interfaces](https://kotlinlang.org/docs/sealed-classes.html)
 */
class WeatherConditions(
    val description : String , 
    @DrawableRes val iconRes: Int
) {
    object ClearSky : WeatherConditions(
        weatherDesc = "Clear sky",
        iconRes = R.drawable.ic_sunny
    )
    object MainlyClear : WeatherConditions(
        weatherDesc = "Mainly clear",
        iconRes = R.drawable.ic_cloudy
    )
    object PartlyCloudy : WeatherConditions(
        weatherDesc = "Partly cloudy",
        iconRes = R.drawable.ic_cloudy
    )
    object Overcast : WeatherConditions(
        weatherDesc = "Overcast",
        iconRes = R.drawable.ic_cloudy
    )
    object Foggy : WeatherConditions(
        weatherDesc = "Foggy",
        iconRes = R.drawable.ic_very_cloudy
    )
    object DepositingRimeFog : WeatherConditions(
        weatherDesc = "Depositing rime fog",
        iconRes = R.drawable.ic_very_cloudy
    )
    object LightDrizzle : WeatherConditions(
        weatherDesc = "Light drizzle",
        iconRes = R.drawable.ic_rainshower
    )
    object ModerateDrizzle : WeatherConditions(
        weatherDesc = "Moderate drizzle",
        iconRes = R.drawable.ic_rainshower
    )
    object DenseDrizzle : WeatherConditions(
        weatherDesc = "Dense drizzle",
        iconRes = R.drawable.ic_rainshower
    )
    object LightFreezingDrizzle : WeatherConditions(
        weatherDesc = "Slight freezing drizzle",
        iconRes = R.drawable.ic_snowyrainy
    )
    object DenseFreezingDrizzle : WeatherConditions(
        weatherDesc = "Dense freezing drizzle",
        iconRes = R.drawable.ic_snowyrainy
    )
    object SlightRain : WeatherConditions(
        weatherDesc = "Slight rain",
        iconRes = R.drawable.ic_rainy
    )
    object ModerateRain : WeatherConditions(
        weatherDesc = "Rainy",
        iconRes = R.drawable.ic_rainy
    )
    object HeavyRain : WeatherConditions(
        weatherDesc = "Heavy rain",
        iconRes = R.drawable.ic_rainy
    )
    object HeavyFreezingRain: WeatherConditions(
        weatherDesc = "Heavy freezing rain",
        iconRes = R.drawable.ic_snowyrainy
    )
    object SlightSnowFall: WeatherConditions(
        weatherDesc = "Slight snow fall",
        iconRes = R.drawable.ic_snowy
    )
    object ModerateSnowFall: WeatherConditions(
        weatherDesc = "Moderate snow fall",
        iconRes = R.drawable.ic_heavysnow
    )
    object HeavySnowFall: WeatherConditions(
        weatherDesc = "Heavy snow fall",
        iconRes = R.drawable.ic_heavysnow
    )
    object SnowGrains: WeatherConditions(
        weatherDesc = "Snow grains",
        iconRes = R.drawable.ic_heavysnow
    )
    object SlightRainShowers: WeatherConditions(
        weatherDesc = "Slight rain showers",
        iconRes = R.drawable.ic_rainshower
    )
    object ModerateRainShowers: WeatherConditions(
        weatherDesc = "Moderate rain showers",
        iconRes = R.drawable.ic_rainshower
    )
    object ViolentRainShowers: WeatherConditions(
        weatherDesc = "Violent rain showers",
        iconRes = R.drawable.ic_rainshower
    )
    object SlightSnowShowers: WeatherConditions(
        weatherDesc = "Light snow showers",
        iconRes = R.drawable.ic_snowy
    )
    object HeavySnowShowers: WeatherConditions(
        weatherDesc = "Heavy snow showers",
        iconRes = R.drawable.ic_snowy
    )
    object ModerateThunderstorm: WeatherConditions(
        weatherDesc = "Moderate thunderstorm",
        iconRes = R.drawable.ic_thunder
    )
    object SlightHailThunderstorm: WeatherConditions(
        weatherDesc = "Thunderstorm with slight hail",
        iconRes = R.drawable.ic_rainythunder
    )
    object HeavyHailThunderstorm: WeatherConditions(
        weatherDesc = "Thunderstorm with heavy hail",
        iconRes = R.drawable.ic_rainythunder
    )

    /**
     * Codes below are from The World Meteorological Organization
     * We get these codes from
     *
     * You can find more information [open-meteo](https://open-meteo.com/en/docs)
     */
    sealed class WeatherConditions(
        val weatherDesc: String,
        @DrawableRes val iconRes: Int
    ) {
        companion object {
            fun fromWMO(code: Int): WeatherConditions {
                return when(code) {
                    0 -> ClearSky
                    1 -> MainlyClear
                    2 -> PartlyCloudy
                    3 -> Overcast
                    45 -> Foggy
                    48 -> DepositingRimeFog
                    51 -> LightDrizzle
                    53 -> ModerateDrizzle
                    55 -> DenseDrizzle
                    56 -> LightFreezingDrizzle
                    57 -> DenseFreezingDrizzle
                    61 -> SlightRain
                    63 -> ModerateRain
                    65 -> HeavyRain
                    66 -> LightFreezingDrizzle
                    67 -> HeavyFreezingRain
                    71 -> SlightSnowFall
                    73 -> ModerateSnowFall
                    75 -> HeavySnowFall
                    77 -> SnowGrains
                    80 -> SlightRainShowers
                    81 -> ModerateRainShowers
                    82 -> ViolentRainShowers
                    85 -> SlightSnowShowers
                    86 -> HeavySnowShowers
                    95 -> ModerateThunderstorm
                    96 -> SlightHailThunderstorm
                    99 -> HeavyHailThunderstorm
                    else -> ClearSky
                }
            }
        }
    }
}

