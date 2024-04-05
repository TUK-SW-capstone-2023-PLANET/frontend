package com.example.planet.repository

import com.example.planet.data.ApiState
import com.example.planet.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RankingRepository @Inject constructor(private val apiService: ApiService) {

    // 대학교 랭킹 3개 조회
    suspend fun getHigherUniversities(): Flow<ApiState> = flow{
        kotlin.runCatching {
            apiService.getHigherUniversities()
        }.onSuccess {
            emit(ApiState.Success(it))
        }.onFailure { error ->
            error.message?.let { emit(ApiState.Error(it)) }
        }
    }.flowOn(Dispatchers.IO)


    // 대학교 유저 랭킹 전체 조회
    suspend fun getUniversityAllUserInfo(userId: Int = 0): Flow<ApiState> = flow{
        kotlin.runCatching {
            apiService.getUniversityAllUserInfo(userId = userId)
        }.onSuccess {
            emit(ApiState.Success(it))
        }.onFailure { error ->
            error.message?.let { emit(ApiState.Error(it)) }
        }
    }.flowOn(Dispatchers.IO)

    // 대학교 유저 랭킹 4개 조회 - 상단 조회
    suspend fun getUniversityPartUserInfo(userId: Int = 0): Flow<ApiState> = flow{
        kotlin.runCatching {
            apiService.getUniversityAllUserInfo(userId = userId)
        }.onSuccess {
            emit(ApiState.Success(it))
        }.onFailure { error ->
            error.message?.let { emit(ApiState.Error(it)) }
        }
    }.flowOn(Dispatchers.IO)

    // 대학교 유저 3개 조회
    suspend fun getUniversityUserInfo(userId: Int = 0): Flow<ApiState> = flow{
        kotlin.runCatching {
            apiService.getUniversityAllUserInfo(userId = userId)
        }.onSuccess {
            emit(ApiState.Success(it))
        }.onFailure { error ->
            error.message?.let { emit(ApiState.Error(it)) }
        }
    }.flowOn(Dispatchers.IO)
}