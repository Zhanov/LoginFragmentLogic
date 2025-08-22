package com.example.ozinsheapplication.data.model


import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("id")
    val id: Int, // 25958
    @SerializedName("username")
    val username: String, // temirzhan@gmail.com
    @SerializedName("email")
    val email: String, // temirzhan@gmail.com
    @SerializedName("roles")
    val roles: List<String>,
    @SerializedName("tokenType")
    val tokenType: String, // Bearer
    @SerializedName("accessToken")
    val accessToken: String // eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZW1pcnpoYW5AZ21haWwuY29tIiwiaWF0IjoxNzU1NzY2NTc4LCJleHAiOjE3ODczMDI1Nzh9.9IPjjHP0-hv9JIkYP14YQcE0H4GuD6UyiTp9zvTOzm5D3dCev0QsI9-wg5jBwNlN6SKOiINGPOR2paBcULUy2Q
)