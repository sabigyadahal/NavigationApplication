package com.example.NavigationApplication.repository

import com.example.NavigationApplication.DashboardResponse
import com.example.navigationapplication.DashboardApi
import retrofit2.Response
import javax.inject.Inject

class DashboardRepository @Inject constructor(private val api: DashboardApi) {
    suspend fun getDashboardData(keypass: String): Response<DashboardResponse> {
        return api.getDashboardData(keypass)
    }
}
