package com.example.NavigationApplication.repository

import com.example.NavigationApplication.LoginRequest
import com.example.NavigationApplication.LoginResponse
import com.example.navigationapplication.AuthApi
import retrofit2.Response
import javax.inject.Inject

class AuthRepository @Inject constructor(private val api: AuthApi) {
    suspend fun login(username: String, password: String): Response<LoginResponse> {
        return api.login(LoginRequest(username, password))
    }
}
