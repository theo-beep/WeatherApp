package com.theolin.weather.domain.models

import androidx.annotation.DrawableRes
import com.theolin.weather.R

/**
 * Sealed class to map all my svg icons into my weather condition object
 *
 * **See Also:** [Sealed classes and interfaces](https://kotlinlang.org/docs/sealed-classes.html)
 */
sealed class WeatherConditions(
    val description : String , 
    @DrawableRes val iconRes: Int
) {
    object ClearSky : WeatherConditions(
        description = "Clear sky",
        iconRes = R.drawable.ic_sunny
    )
    object MainlyClear : WeatherConditions(
        description = "Mainly clear",
        iconRes = R.drawable.ic_cloudy
    )
    object PartlyCloudy : WeatherConditions(
        description = "Partly cloudy",
        iconRes = R.drawable.ic_cloudy
    )
    object Overcast : WeatherConditions(
        description = "Overcast",
        iconRes = R.drawable.ic_cloudy
    )
    object Foggy : WeatherConditions(
        description = "Foggy",
        iconRes = R.drawable.ic_very_cloudy
    )
    object DepositingRimeFog : WeatherConditions(
        description = "Depositing rime fog",
        iconRes = R.drawable.ic_very_cloudy
    )
    object LightDrizzle : WeatherConditions(
        description = "Light drizzle",
        iconRes = R.drawable.ic_rainshower
    )
    object ModerateDrizzle : WeatherConditions(
        description = "Moderate drizzle",
        iconRes = R.drawable.ic_rainshower
    )
    object DenseDrizzle : WeatherConditions(
        description = "Dense drizzle",
        iconRes = R.drawable.ic_rainshower
    )
    object LightFreezingDrizzle : WeatherConditions(
        description = "Slight freezing drizzle",
        iconRes = R.drawable.ic_snowyrainy
    )
    object DenseFreezingDrizzle : WeatherConditions(
        description = "Dense freezing drizzle",
        iconRes = R.drawable.ic_snowyrainy
    )
    object SlightRain : WeatherConditions(
        description = "Slight rain",
        iconRes = R.drawable.ic_rainy
    )
    object ModerateRain : WeatherConditions(
        description = "Rainy",
        iconRes = R.drawable.ic_rainy
    )
    object HeavyRain : WeatherConditions(
        description = "Heavy rain",
        iconRes = R.drawable.ic_rainy
    )
    object HeavyFreezingRain: WeatherConditions(
        description = "Heavy freezing rain",
        iconRes = R.drawable.ic_snowyrainy
    )
    object SlightSnowFall: WeatherConditions(
        description = "Slight snow fall",
        iconRes = R.drawable.ic_snowy
    )
    object ModerateSnowFall: WeatherConditions(
        description = "Moderate snow fall",
        iconRes = R.drawable.ic_heavysnow
    )
    object HeavySnowFall: WeatherConditions(
        description = "Heavy snow fall",
        iconRes = R.drawable.ic_heavysnow
    )
    object SnowGrains: WeatherConditions(
        description = "Snow grains",
        iconRes = R.drawable.ic_heavysnow
    )
    object SlightRainShowers: WeatherConditions(
        description = "Slight rain showers",
        iconRes = R.drawable.ic_rainshower
    )
    object ModerateRainShowers: WeatherConditions(
        description = "Moderate rain showers",
        iconRes = R.drawable.ic_rainshower
    )
    object ViolentRainShowers: WeatherConditions(
        description = "Violent rain showers",
        iconRes = R.drawable.ic_rainshower
    )
    object SlightSnowShowers: WeatherConditions(
        description = "Light snow showers",
        iconRes = R.drawable.ic_snowy
    )
    object HeavySnowShowers: WeatherConditions(
        description = "Heavy snow showers",
        iconRes = R.drawable.ic_snowy
    )
    object ModerateThunderstorm: WeatherConditions(
        description = "Moderate thunderstorm",
        iconRes = R.drawable.ic_thunder
    )
    object SlightHailThunderstorm: WeatherConditions(
        description = "Thunderstorm with slight hail",
        iconRes = R.drawable.ic_rainythunder
    )
    object HeavyHailThunderstorm: WeatherConditions(
        description = "Thunderstorm with heavy hail",
        iconRes = R.drawable.ic_rainythunder
    )

    /**
     * Codes below are from The World Meteorological Organization
     * We get these codes from
     *
     * You can find more information [open-meteo](https://open-meteo.com/en/docs)
     */
    companion object {
        fun fromWMO(code: Int?): WeatherConditions {
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

