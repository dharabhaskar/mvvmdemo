package com.dharabhaskar.mvvm.data.repositories

import com.dharabhaskar.mvvm.data.network.MyApi
import com.dharabhaskar.mvvm.data.network.responses.AuthResponse
import retrofit2.Response

class UserRepository {
    suspend fun userLogin(email: String, password: String): Response<AuthResponse> {
        return MyApi().login(email, password)
    }
}