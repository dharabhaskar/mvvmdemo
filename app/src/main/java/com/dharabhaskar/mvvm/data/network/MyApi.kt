package com.dharabhaskar.mvvm.data.network

import com.dharabhaskar.mvvm.data.network.responses.AuthResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface MyApi {
    @FormUrlEncoded
    @POST("login")
    suspend fun login(
        @Field("email") email:String,
        @Field("email") password:String
    ): Response<AuthResponse>

    @FormUrlEncoded
    @POST("signup")
    fun signup(
        @Field("email") email:String,
        @Field("email") password:String
    ): Call<ResponseBody>


    companion object{
        operator fun invoke():MyApi{
            return Retrofit.Builder()
                .baseUrl("https://api.simplifiedcoding.in/course-apis/mvvm/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApi::class.java)
        }
    }
}