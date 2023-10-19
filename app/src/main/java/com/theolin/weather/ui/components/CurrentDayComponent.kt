package com.theolin.weather.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.theolin.weather.R
import com.theolin.weather.common.Constants.DEGREE_CELSIUS
import com.theolin.weather.common.Constants.HUMIDITY_UNIT
import com.theolin.weather.common.Constants.PRESSURE_UNIT
import com.theolin.weather.common.Constants.WIND_UNIT

@Composable
fun CurrentDayComponent(
    temperature: String,
    pressure: String,
    windSpeed: String,
    humidity: String,
    description: String,
    @DrawableRes iconRes: Int,
) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f),
        ),
        shape = RoundedCornerShape(10.dp),

        ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier.size(140.dp),
                painter = painterResource(id = iconRes),
                contentDescription = null
            )
            Text(
                text = temperature + DEGREE_CELSIUS,
                color = Color.White,
                style = MaterialTheme.typography.displayLarge,
                modifier = Modifier
                    .padding(16.dp),
                textAlign = TextAlign.Center,
            )
            Text(
                text = description,
                color = Color.White,
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier
                    .padding(16.dp),
                textAlign = TextAlign.Center,
            )
            Row(
                modifier = Modifier.padding(8.dp),
                horizontalArrangement = Arrangement.spacedBy(48.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                InfoSection(value = pressure + PRESSURE_UNIT, icon = R.drawable.ic_pressure)
                InfoSection(value = humidity + HUMIDITY_UNIT, icon = R.drawable.ic_drop)
                InfoSection(value = windSpeed + WIND_UNIT, icon = R.drawable.ic_wind)
            }
        }
    }
}


@Composable
fun InfoSection(
    value: String,
    @DrawableRes icon: Int
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier.size(24.dp),
            painter = painterResource(id = icon),
            colorFilter = ColorFilter.tint(Color.White),
            contentDescription = null
        )
        Text(
            text = value,
            color = Color.White,
            style = MaterialTheme.typography.labelLarge,
            modifier = Modifier
                .padding(start = 4.dp, bottom = 8.dp, top = 4.dp),
            textAlign = TextAlign.Center,
        )
    }

}

@Preview
@Composable
fun PreviewCurrentDayComponent() {
  Column (
      modifier = Modifier.padding(8.dp)
  ){
      CurrentDayComponent(
          temperature = "20",
          pressure = "20",
          windSpeed = "20",
          humidity = "20",
          description = "Description",
          iconRes = R.drawable.ic_sunny
      )
  }
}