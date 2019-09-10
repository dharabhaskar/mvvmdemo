package com.dharabhaskar.mvvm.data.repositories

import com.dharabhaskar.mvvm.data.network.MyApi
import com.dharabhaskar.mvvm.data.network.SafeApiRequest
import com.dharabhaskar.mvvm.data.network.responses.AuthResponse
import retrofit2.Response

class UserRepository : SafeApiRequest() {
    suspend fun userLogin(email: String, password: String): AuthResponse {
        return apiRequest { MyApi().login(email, password) }
    }
}