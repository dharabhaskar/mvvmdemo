package com.dharabhaskar.mvvm.ui.auth

import com.dharabhaskar.mvvm.data.db.User

interface AuthListener {
    fun onStarted()
    fun onSuccess(user:User?)
    fun onError(errMsg:String)
}