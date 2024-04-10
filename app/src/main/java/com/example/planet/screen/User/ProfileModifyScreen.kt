package com.example.planet.screen.User

import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.planet.R
import com.example.planet.TAG
import com.example.planet.component.common.RedTextButton
import com.example.planet.component.user.UserIdTextField
import com.example.planet.component.user.UserNicknameTextField
import com.example.planet.component.user.UserPwTextField
import com.example.planet.util.noRippleClickable
import com.example.planet.viewmodel.UserViewModel

@Composable
fun ProfileModifyScreen(userViewModel: UserViewModel, onClick: () -> Unit) {

    BackHandler {
        onClick()
    }

    if (userViewModel.editState) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .zIndex(1f),
            color = Color.Black.copy(alpha = 0.5f)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Text(
                    text = "취소",
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    modifier = Modifier.noRippleClickable {
                        userViewModel.changeEditScreen()
                    })
                UserNicknameTextField(
                    text = userViewModel.nicknameTextValue,
                    onValueChange = { userViewModel.nicknameTextValue = it },
                    trailingText = "9 / 20",
                    modifier = Modifier.align(Alignment.Center).fillMaxWidth()
                )
//                TextField(
//                    value = userViewModel.nicknameTextValue,
//                    onValueChange = { userViewModel.nicknameTextValue = it },
//                    maxLines = 1,
//                    singleLine = true,
//                    modifier = Modifier
//                        .align(Alignment.Center),
//                    textStyle = TextStyle.Default.copy(
//                        fontSize = 16.sp,
//                        textAlign = TextAlign.Center,
//                        color = Color.White,
//                        fontWeight = FontWeight.SemiBold
//                    ),
//                    colors = TextFieldDefaults.colors(
//                        unfocusedContainerColor = Color.Transparent,
//                        focusedContainerColor = Color.Transparent,
//                        focusedIndicatorColor = Color.White,
//                        unfocusedIndicatorColor = Color.White,
//                    ),
//                )
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBackIosNew,
            contentDescription = null,
            tint = colorResource(id = R.color.font_background_color1),
            modifier = Modifier
                .align(Alignment.TopStart)
                .noRippleClickable {
                    onClick()
                }
        )
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "프로필 수정",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 32.dp),
            thickness = 1.dp,
            color = colorResource(id = R.color.font_background_color3)
        )
        Box(modifier = Modifier.wrapContentSize()) {
            Card(
                modifier = Modifier
                    .size(115.dp)
                    .aspectRatio(1f), shape = CircleShape
            ) {
//                AsyncImage(
//                    model = ImageRequest.Builder(LocalContext.current)
//                        .data(userIconUrl)
//                        .crossfade(true).build(),
//                    contentDescription = null,
//                    modifier = Modifier
//                )
                Image(
                    painter = painterResource(id = R.drawable.temporary_user_icon),
                    contentDescription = null,
                )
            }
            Card(
                shape = CircleShape,
                modifier = Modifier
                    .size(28.dp)
                    .align(Alignment.BottomEnd),
                elevation = CardDefaults.elevatedCardElevation(2.dp)
            ) {
                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.fillMaxSize(),
                    colors = IconButtonDefaults.iconButtonColors(containerColor = Color.White)
                ) {
                    Icon(
                        imageVector = Icons.Default.CameraAlt,
                        contentDescription = null,
                        modifier = Modifier.size(14.dp)
                    )
                }
            }
        }


        Spacer(modifier = Modifier.height(16.dp))

        Box(modifier = Modifier.fillMaxWidth()) {
            Text(text = "Happy Been", fontSize = 16.sp, modifier = Modifier.align(Alignment.Center))
            Image(
                painter = painterResource(id = R.drawable.edit_icon),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .size(20.dp)
                    .clickable {
                        userViewModel.changeEditScreen()
                    }
            )

        }

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp, bottom = 8.dp),
            thickness = 1.dp,
            color = colorResource(id = R.color.font_background_color3)
        )

        Box(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "나랑 같이 플로깅 할 사람",
                fontSize = 11.sp,
                modifier = Modifier.align(Alignment.Center)
            )
            Image(
                painter = painterResource(id = R.drawable.edit_icon),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .size(20.dp)
                    .noRippleClickable {
                        userViewModel.changeEditScreen()
                    }
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp, bottom = 8.dp),
            thickness = 2.dp,
            color = colorResource(id = R.color.font_background_color3)
        )

        Spacer(modifier = Modifier.height(9.dp))

        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.exclamation_mark_logo),
                contentDescription = null,
                modifier = Modifier.size(14.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "회원정보", fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.height(9.dp))

        UserIdTextField(
            headerText = "아이디",
            textValue = userViewModel.idTextValue.value,
            onValueChange = { userViewModel.idTextValue.value = it },
            enabled = userViewModel.duplicateCheck,
            placeholder = "TukoreaUniv0921"
        ) {
            Text(
                text = "*아이디는 특수문자 사용이 불가능합니다.",
                fontSize = 8.sp,
                color = colorResource(id = R.color.font_background_color2)
            )
            Spacer(modifier = Modifier.height(16.dp))
        }

        UserPwTextField(
            headerText = "비밀번호",
            textValue = userViewModel.pwTextValue.value,
            onValueChange = { userViewModel.pwTextValue.value = it },
            placeholder = "******"
        ) {
            Text(
                text = "* 특수문자, 숫자, 대문자를 포함하여 8자 이상",
                fontSize = 8.sp,
                color = colorResource(id = R.color.font_background_color2)
            )
            Spacer(modifier = Modifier.height(16.dp))
        }

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            thickness = 2.dp,
            color = colorResource(id = R.color.font_background_color3)
        )

        Text(
            text = "회원정보 삭제",
            fontWeight = FontWeight.SemiBold,
            fontSize = 10.sp,
            style = TextStyle(textDecoration = TextDecoration.Underline),
            color = colorResource(id = R.color.red)
        )
    }
}
