package com.theolin.weather.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.theolin.weather.R
import com.theolin.weather.common.Constants.DEGREE_CELSIUS

@Composable
fun HourForecastComponent(
    time: String,
    @DrawableRes icon: Int,
    temperature: String
) {

    Card(
        modifier = Modifier.padding(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = Modifier.padding(bottom = 2.dp),
                text = time,
                style = MaterialTheme.typography.labelMedium
            )
            Image(
                modifier = Modifier.size(48.dp),
                painter = painterResource(id = icon),
                contentDescription = null
            )
            Text(
                modifier = Modifier.padding(top = 2.dp),
                text = temperature + DEGREE_CELSIUS,
                style = MaterialTheme.typography.labelMedium
            )
        }

    }
}

@Preview
@Composable
fun PreviewHourForecast() {
    Column(modifier = Modifier.padding(8.dp)) {
        HourForecastComponent(time = "2:00", icon = R.drawable.ic_sunny, temperature = "20")
    }
}