package com.example.planet.domain.usecase.login

import com.example.planet.data.remote.dto.ApiState
import com.example.planet.data.remote.dto.request.signin.LoginInfo
import com.example.planet.data.repository.LoginRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PostLoginUseCase @Inject constructor(private val loginRepository: LoginRepository) {
    suspend operator fun invoke(loginInfo: LoginInfo): Flow<ApiState> {
        return loginRepository.postLogin(loginInfo)
    }
}