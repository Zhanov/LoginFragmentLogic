package com.example.ozinsheapplication.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ozinsheapplication.data.ApiService
import com.example.ozinsheapplication.data.ServiceBuilder
import com.example.ozinsheapplication.data.model.LoginRecponse
import com.example.ozinsheapplication.data.model.LoginRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel():ViewModel() {
    private val _loginResponce: MutableLiveData<LoginRecponse> = MutableLiveData()
    val loginResponce:LiveData<LoginRecponse> = _loginResponce

    private val _errorResponce: MutableLiveData<String> = MutableLiveData()
    val errorResponce:LiveData<String> = _errorResponce


    fun loginUser(email: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = ServiceBuilder.buildService(ApiService::class.java)

            runCatching { response.loginUser(LoginRequest(email, password)) }
                .onSuccess {
                    _loginResponce.postValue(it)
                }
                .onFailure {
                    _errorResponce.postValue(it.message)

                }
        }
    }

}