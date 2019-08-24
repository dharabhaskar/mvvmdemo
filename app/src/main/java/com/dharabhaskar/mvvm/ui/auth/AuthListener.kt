package com.dharabhaskar.mvvm.ui.auth

interface AuthListener {
    fun onStarted()
    fun onSuccess()
    fun onError(errMsg:String)
}