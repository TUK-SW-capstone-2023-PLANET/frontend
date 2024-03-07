package com.example.planet.screen.main.plogging

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.planet.component.main.PloggingHelpCard
import com.example.planet.R

@Preview(showBackground = true)
@Composable
fun PloggingHelpScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            PloggingHelpCard(
                image = painterResource(id = R.drawable.plogginghelp_card1),
                title = "초급자를 위한 플랜",
                subTitle = "PLANET 초급자를 위한 계획"
            ) {

            }
            PloggingHelpCard(
                image = painterResource(id = R.drawable.plogginghelp_card2),
                title = "누구나 편하게 할 수 있는 플랜",
                subTitle = "누구나 쉽게 할 수 있는 PLANET 계획"
            ) {

            }
        }
                Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            PloggingHelpCard(
                image = painterResource(id = R.drawable.plogginghelp_card3),
                title = "중급자를 위한 플랜",
                subTitle = "플로깅 숙련자를 위한 계획"
            ) {

            }
        }
    }
}