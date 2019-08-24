package com.dharabhaskar.mvvm.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel

class AuthViewModel: ViewModel() {
     var emailID:String?=null
     var password:String?=null

    var authListener:AuthListener?=null

    fun onLoginButtonClick(view: View){
        authListener?.onStarted()
        if(emailID.isNullOrEmpty() || password.isNullOrEmpty()){
            //Display err msg
            authListener?.onError("Empty password or email")
            return
        }
        authListener?.onSuccess()
        //Success...
    }

}