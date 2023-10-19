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

package com.theolin.weather.ui.theme

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val DarkPurple = Color(0xFF31255a)
val LightPurple = Color(0xFF8fe0ff)
val MediumPurple = Color(0xFF75b4e3)
val Gray = Color(0xFF54416d)
val VeryDarkPurple = Color(0xFF2b235a)


val gradientSunny = Brush.linearGradient(
    colors = listOf(LightPurple, MediumPurple),
    start = Offset(0f, Float.POSITIVE_INFINITY),
    end = Offset(Float.POSITIVE_INFINITY, 0f)
)


val gradientCloudy = Brush.linearGradient(
    colors = listOf(MediumPurple, Gray, VeryDarkPurple),
    start = Offset(0f, Float.POSITIVE_INFINITY),
    end = Offset(Float.POSITIVE_INFINITY, 0f)
)

val gradientRainy = Brush.linearGradient(
    colors = listOf(Gray, DarkPurple, VeryDarkPurple),
    start = Offset(0f, Float.POSITIVE_INFINITY),
    end = Offset(Float.POSITIVE_INFINITY, 0f)
)

val gradientSnow = Brush.linearGradient(
    colors = listOf(LightPurple, Color.White),
    start = Offset(0f, Float.POSITIVE_INFINITY),
    end = Offset(Float.POSITIVE_INFINITY, 0f)
)

val DefaultBrush = Brush.linearGradient(
    colors = listOf( Color.White, Color.White),
    start = Offset(0f, Float.POSITIVE_INFINITY),
    end = Offset(Float.POSITIVE_INFINITY, 0f)
)

