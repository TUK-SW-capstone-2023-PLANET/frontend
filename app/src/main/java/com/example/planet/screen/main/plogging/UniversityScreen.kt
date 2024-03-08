package com.example.planet.screen.main.plogging

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planet.R
import com.example.planet.component.main.SubTitle
import com.example.planet.component.main.SubTitleDescription
import com.example.planet.component.main.plogging.UniversityContentRow
import com.example.planet.component.main.plogging.UniversityGraph
import kotlinx.coroutines.delay
import java.text.DecimalFormat
import kotlin.math.round

@Composable
@Preview(showBackground = true)
fun UniversityScreen() {

    var visible by remember { mutableStateOf(false) }
    var scrollState = rememberScrollState()
    var GraphHeight2th: Int = round(120 / 1120921.0 * 921218.0).toInt()
    var GraphHeight3th: Int = round(120 / 1120921.0 * 218213.0).toInt()
    val universityPeople = listOf<UniversityPerson>(
        UniversityPerson(rank = 1, name = "행복하고픈 정대영", score = 371357, contribute = 33.129),
        UniversityPerson(rank = 2, name = "고통받는 이승민", score = 268589, contribute = 23.961),
        UniversityPerson(rank = 3, name = "컴공 간판 강기환", score = 21075, contribute = 1.88),
        UniversityPerson(rank = 4, name = "일론머스크", score = 19716, contribute = 1.758),
    )
    val dec = DecimalFormat("#,###")

    LaunchedEffect(Unit) {
        delay(200)
        visible = true
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .verticalScroll(scrollState)
    ) {
        Row(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier
                    .wrapContentSize(),
                verticalAlignment = Alignment.Bottom,
            ) {
                SubTitle(title = "대학교 순위", modifier = Modifier.padding(end = 8.dp))
                SubTitleDescription("학교를 인증하여, 학교의 위상을 높히세요!!")
            }
            Box(modifier = Modifier.wrapContentSize()) {
                Icon(
                    imageVector = Icons.Default.ArrowForwardIos,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(start = 7.dp)
                        .size(20.dp),
                    tint = Color(0xFFF2F2F2)
                )
                Icon(
                    imageVector = Icons.Default.ArrowForwardIos,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(start = 14.dp)
                        .size(20.dp),
                    tint = Color(0xFFD2D2D2)

                )
                Icon(
                    imageVector = Icons.Default.ArrowForwardIos,
                    contentDescription = null,
                    modifier = Modifier.size(20.dp),
                    tint = Color(0xFFFAFAFA)
                )
            }

        }
        Column(
            modifier = Modifier
                .height(220.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {

                UniversityGraph(
                    visible = visible,
                    universityLogo = painterResource(id = R.drawable.university1),
                    score = "921,218",
                    graphHeight = GraphHeight2th.dp,
                    colors = listOf(Color(0XFFD1CFCF), Color(0XFFFFFFFF)),
                    universityName = "연세대학교",
                    medal = painterResource(id = R.drawable.ranking_number2)
                )
                UniversityGraph(
                    visible = visible,
                    universityLogo = painterResource(id = R.drawable.university2),
                    score = "1,120,921",
                    graphHeight = 120.dp,
                    colors = listOf(Color(0xFFFFCC31), Color(0XFFFFFFFF)),
                    universityName = "한국공학대학교",
                    medal = painterResource(id = R.drawable.ranking_number1)
                )
                UniversityGraph(
                    visible = visible,
                    universityLogo = painterResource(id = R.drawable.university3),
                    score = "218,213",
                    graphHeight = GraphHeight3th.dp,
                    colors = listOf(Color(0xFFE1B983), Color(0XFFFFFFFF)),
                    universityName = "고려대학교",
                    medal = painterResource(id = R.drawable.ranking_number3)
                )
            }

        }
        Divider(
            thickness = 1.dp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            color = colorResource(id = R.color.font_background_color3)
        )
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
            Row(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = Modifier
                        .wrapContentSize(),
                    verticalAlignment = Alignment.Bottom
                ) {
                    SubTitle(title = "대학교와 함께하기", modifier = Modifier.padding(end = 8.dp))
                    SubTitleDescription("내 학교와 같이 뛰면 즐거움과 성취감 두 배!")
                }
                Box(modifier = Modifier.wrapContentSize()) {
                    Icon(
                        imageVector = Icons.Default.ArrowForwardIos,
                        contentDescription = null,
                        modifier = Modifier
                            .padding(start = 7.dp)
                            .size(20.dp),
                        tint = Color(0xFFF2F2F2)
                    )
                    Icon(
                        imageVector = Icons.Default.ArrowForwardIos,
                        contentDescription = null,
                        modifier = Modifier
                            .padding(start = 14.dp)
                            .size(20.dp),
                        tint = Color(0xFFD2D2D2)

                    )
                    Icon(
                        imageVector = Icons.Default.ArrowForwardIos,
                        contentDescription = null,
                        modifier = Modifier.size(20.dp),
                        tint = Color(0xFFFAFAFA)
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth(0.3f)
                        .aspectRatio(1f), shape = CircleShape
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.plogginghelp_card2),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                    )
                }
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .height(108.dp)
                        .padding(start = 32.dp),
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Row(modifier = Modifier, verticalAlignment = Alignment.Bottom) {
                        Image(
                            painter = painterResource(id = R.drawable.university2),
                            contentDescription = null,
                            modifier = Modifier.size(25.dp)
                        )
                        Text(
                            text = "한국공학대학교",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            modifier = Modifier.padding(horizontal = 4.dp)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.ranking_number1),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                    Text(text = "HappyBean", fontSize = 16.sp)
                    Text(text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                fontSize = 14.sp,
                                color = colorResource(id = R.color.font_background_color1)
                            )
                        ) {
                            append("1,120")
                            append("점")
                        }
                        withStyle(
                            style = SpanStyle(
                                fontSize = 12.sp,
                                color = colorResource(id = R.color.font_background_color3)
                            )
                        ) {
                            append(" (")
                            append("0.09")
                            append("%)")
                        }


                    })
                    Text(text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                fontSize = 12.sp,
                                color = colorResource(id = R.color.font_background_color1)
                            )
                        ) {
                            append("73")
                            append("등")
                        }
                    })
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                Divider(thickness = 1.dp, modifier = Modifier.fillMaxWidth().padding(bottom = 2.dp), color = colorResource(id = R.color.font_background_color3))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 24.dp)
                ) {
                    Row(modifier = Modifier.fillMaxWidth(0.5f)) {
                        Text(
                            text = "순위",
                            color = colorResource(id = R.color.font_background_color2),
                            fontSize = 12.sp,
                            modifier = Modifier.fillMaxWidth(0.3f)
                        )
                        Text(
                            text = "이름",
                            color = colorResource(id = R.color.font_background_color2),
                            fontSize = 12.sp,
                            modifier = Modifier.weight(1f)
                        )
                    }
                    Row(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "점수",
                            color = colorResource(id = R.color.font_background_color2),
                            fontSize = 12.sp,
                            modifier = Modifier.fillMaxWidth(0.5f)
                        )
                        Text(
                            text = "기여도",
                            color = colorResource(id = R.color.font_background_color2),
                            fontSize = 12.sp,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
                Divider(thickness = 1.dp, modifier = Modifier.fillMaxWidth().padding(vertical = 2.dp), color = colorResource(id = R.color.font_background_color3))
                universityPeople.forEach {
                    UniversityContentRow(rank = it.rank, name = it.name, score = dec.format(it.score), contribute = it.contribute)
                }
            }
        }

    }
}

data class UniversityPerson(
    val rank: Int,
    val name: String,
    val score: Int,
    val contribute: Double
)