package com.example.planet.presentation.ui.main.record.screen.map.screen

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.LocalFireDepartment
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.planet.R
import com.example.planet.TAG
import com.example.planet.component.map.map.TrashCanItem
import com.example.planet.presentation.ui.main.record.screen.map.component.RecordMapTab
import com.example.planet.presentation.ui.main.record.screen.map.component.RecordMapTextField
import com.naver.maps.map.compose.DisposableMapEffect
import com.naver.maps.map.compose.ExperimentalNaverMapApi
import com.naver.maps.map.compose.LocationTrackingMode
import com.naver.maps.map.compose.MapProperties
import com.naver.maps.map.compose.MapUiSettings
import com.naver.maps.map.compose.NaverMap
import com.naver.maps.map.compose.rememberCameraPositionState
import com.naver.maps.map.compose.rememberFusedLocationSource
import ted.gun0912.clustering.naver.TedNaverClustering

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalNaverMapApi::class)
@Composable
fun MapScreen(
    trashCans: List<TrashCanItem>,
    hotPlaces: List<TrashCanItem>,
    readAllTrashCan: suspend () -> Unit,
    readAllHotPlace: suspend () -> Unit,
    startSearchActivity: () -> Unit,
) {
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current

    var mapProperties by remember {
        mutableStateOf(
            MapProperties(
                maxZoom = 18.0,
                minZoom = 7.0,
                locationTrackingMode = LocationTrackingMode.NoFollow,
            )
        )
    }


    var mapUiSettings by remember {
        mutableStateOf(
            MapUiSettings(
                isLocationButtonEnabled = true,
                isScrollGesturesEnabled = true,
                isRotateGesturesEnabled = true,
                isZoomGesturesEnabled = true,
                isZoomControlEnabled = false,
                isTiltGesturesEnabled = false,
                isIndoorLevelPickerEnabled = false,
                isScaleBarEnabled = false,
                isCompassEnabled = false
            )
        )
    }

    val locationSource = rememberFusedLocationSource(isCompassEnabled = true)
    val cameraPositionState = rememberCameraPositionState()

    var tabSelected by remember {
        mutableIntStateOf(0)
    }

    LaunchedEffect(tabSelected) {
        Log.d(TAG, "tabSelected: $tabSelected")
        readAllTrashCan()
        readAllHotPlace()
    }

    Box(modifier = Modifier.fillMaxSize()) {
        NaverMap(
            locationSource = locationSource,
            cameraPositionState = cameraPositionState,
            properties = mapProperties,
            uiSettings = mapUiSettings,
        ) {
            Log.d(TAG, "trashCans: $trashCans")

            if (tabSelected == 0) {

            } else {
                val context = LocalContext.current
                var clusterManager by remember { mutableStateOf<TedNaverClustering<TrashCanItem>?>(null) }
                DisposableMapEffect(trashCans) { map ->
                    if (clusterManager == null) {
                        clusterManager = TedNaverClustering.with<TrashCanItem>(context, map).make()
                    }
                    clusterManager?.addItems(trashCans)
                    onDispose {
                        clusterManager?.clearItems()
                    }
                }
            }



//            Marker()
//            NaverMapClustering(items = if (tabSelected == 1)trashCans else emptyList())
//            if (tabSelected == 0) {
//                hotPlaces.forEach {
//                    // TODO: 나중에 리스트 타입 수정할 것
//                    CircleOverlay(
//                        center = LatLng(
//                            cameraPositionState.position.target.latitude,
//                            cameraPositionState.position.target.longitude
//                        ), radius = 100.0,
//                        color = colorResource(R.color.main_color2).copy(alpha = 0.7f)
//                    )
//                }
//            }
        }
        Column(
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 8.dp)
                .fillMaxWidth()
        ) {
            RecordMapTextField(
                modifier = Modifier,
                placeholder = "주소, 장소 검색",
                icon = Icons.Outlined.Search
            ) {
                startSearchActivity()
            }
            Spacer(modifier = Modifier.padding(top = 8.dp))
            Row {
                RecordMapTab(
                    modifier = Modifier.padding(end = 8.dp),
                    selected = { tabSelected == 0 },
                    icon = Icons.Outlined.LocalFireDepartment,
                    text = "핫 플레이스"
                ) {
                    tabSelected = 0
                }
                RecordMapTab(
                    modifier = Modifier,
                    selected = { tabSelected == 1 },
                    icon = Icons.Outlined.Delete,
                    text = "쓰레기통"
                ) {
                    tabSelected = 1
                }
            }
        }

        Card(
            modifier = Modifier
                .padding(end = 20.dp, bottom = 20.dp)
                .size(45.dp)
                .align(Alignment.BottomEnd),
            colors = CardDefaults.cardColors(
                containerColor = colorResource(id = R.color.main_color2),
                contentColor = Color.White
            )
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                Icon(
                    imageVector = Icons.Outlined.Delete,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier
                        .fillMaxSize(0.8f)
                        .align(
                            Alignment.Center
                        )
                )
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier
                        .fillMaxSize(0.3f)
                        .align(
                            Alignment.Center
                        )
                        .offset(0.dp, 2.dp)
                )
            }
        }
    }
}

//class ItemKey(val id: Int, private val latLng: LatLng) : ClusteringKey {
//    override fun getPosition() = latLng
//
//    override fun equals(other: Any?): Boolean {
//        if (this === other) return true
//        if (other == null || javaClass != other.javaClass) return false
//        val itemKey = other as ItemKey
//        return id == itemKey.id
//    }
//
//    override fun hashCode() = id
//}