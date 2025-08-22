package com.example.ozinsheapplication.data

import com.example.ozinsheapplication.data.model.LoginResponse
import com.example.ozinsheapplication.data.model.LoginRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("/auth/V1/signin")
    suspend fun loginUser(@Body loginRequest: LoginRequest): LoginResponse
}