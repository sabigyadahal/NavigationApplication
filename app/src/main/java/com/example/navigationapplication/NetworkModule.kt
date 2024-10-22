package com.example.navigationapplication



import com.example.NavigationApplication.DashboardResponse
import com.example.NavigationApplication.LoginRequest
import com.example.NavigationApplication.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface AuthApi {
    @POST("/sydney/auth")  // Change based on class location
    suspend fun login(@Body loginRequest: LoginRequest): Response<LoginResponse>
}

interface DashboardApi {
    @GET("/dashboard/{keypass}")
    suspend fun getDashboardData(@Path("keypass") keypass: String): Response<DashboardResponse>
}
