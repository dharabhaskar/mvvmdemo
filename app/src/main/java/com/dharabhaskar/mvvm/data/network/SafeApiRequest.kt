package com.dharabhaskar.mvvm.data.network

import com.dharabhaskar.mvvm.utils.ApiException
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response
import java.lang.StringBuilder


abstract class SafeApiRequest {
    suspend fun <T:Any> apiRequest(call:suspend()-> Response<T>):T {
        val response = call.invoke()

        if (response.isSuccessful) {
            return response.body()!!
        } else {
            val error = response.errorBody()?.toString()

            val message = StringBuilder()
            error?.let {
                try {
                    message.append(JSONObject(it).getString("message"))
                } catch (exception: JSONException) {}
            }
            message.append("Error Code:${response.code()}")
            throw ApiException(message.toString())
        }
    }
}