package com.example.planet.component.main.plogging

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.planet.R

@Composable
fun SeasonContentRow(
    medal: @Composable () -> Unit,
    rank: Int,
    tier: String,
    nickname: String,
    score: String,
    universityLogo: String,
    color: Color = Color.White
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = color)
            .padding(vertical = 2.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth(0.3f)
                .height(IntrinsicSize.Min),
            verticalAlignment = Alignment.CenterVertically
        ) {
            medal()
            Text(
                text = rank.toString() + "등",
                color = colorResource(id = R.color.font_background_color2),
                fontSize = 12.sp,
                modifier = Modifier.weight(1f)
            )

            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(tier)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize(0.8f)
            )
        }
        Text(
            text = nickname,
            color = colorResource(id = R.color.font_background_color2),
            fontSize = 12.sp,
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Start
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .height(IntrinsicSize.Min),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "${score}점",
                color = colorResource(id = R.color.font_background_color2),
                fontSize = 12.sp,
                modifier = Modifier.weight(1f)
            )
            Box(
                modifier = Modifier
                    .weight(1f)
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(universityLogo)
                        .crossfade(true)
                        .build(),
                    contentDescription = null,
                    modifier = Modifier
                )
            }
        }
    }
    Divider(
        thickness = 1.dp,
        modifier = Modifier.fillMaxWidth(),
        color = colorResource(id = R.color.font_background_color3)
    )
}