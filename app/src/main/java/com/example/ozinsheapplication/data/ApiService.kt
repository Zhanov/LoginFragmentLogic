package com.example.ozinsheapplication.data

import android.telecom.Call
import com.example.ozinsheapplication.data.model.LoginRecponse
import com.example.ozinsheapplication.data.model.LoginRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("/auth/V1/signin")
    suspend fun loginUser(@Body loginRequest: LoginRequest): LoginRecponse
}