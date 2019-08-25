package com.dharabhaskar.mvvm.data.network.responses

import com.dharabhaskar.mvvm.data.db.User
import com.google.gson.Gson

data class AuthResponse(
    val isSuccessful:Boolean?=false,
    val message:String?=null,
    val user:User?=null
){
    fun toJSONString(): String {
        return Gson().toJson(this)
    }
}