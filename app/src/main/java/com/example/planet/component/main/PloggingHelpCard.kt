package com.example.planet.component.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planet.R
import com.example.planet.util.noRippleClickable

@Composable
fun PloggingHelpCard(image: Painter, title: String, subTitle: String, onClick:() -> Unit) {
    Column(modifier = Modifier.background(color = Color.Transparent).wrapContentSize().noRippleClickable { onClick() }) {
        Card(
            shape = RoundedCornerShape(8.dp),
            elevation = CardDefaults.elevatedCardElevation(4.dp),
            modifier = Modifier.size(150.dp).padding(bottom = 8.dp)
        ) {
            Image(
                painter = image,
                contentScale = ContentScale.Crop,
                contentDescription = null
            )
        }
        Text(text = title, fontWeight = FontWeight.Bold, fontSize = 12.sp)
        Text(text = subTitle, color = colorResource(id = R.color.font_background_color2), fontSize = 8.sp)
    }

}