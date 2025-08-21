package com.example.ozinsheapplication.data.model


import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("email")
    val email: String, // temirzhan@gmail.com
    @SerializedName("password")
    val password: String // myPassword
)