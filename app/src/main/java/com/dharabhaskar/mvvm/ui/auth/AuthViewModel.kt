package com.dharabhaskar.mvvm.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.dharabhaskar.mvvm.data.repositories.UserRepository
import com.dharabhaskar.mvvm.utils.Coroutines
import java.lang.Exception

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


        Coroutines.main{
            try{
                val loginResponse=UserRepository().userLogin(emailID!!,password!!)

                if(loginResponse.isSuccessful!!){
                    authListener?.onSuccess(loginResponse?.user)
                }
            }catch (ex:Exception){
                authListener?.onError(ex.message!!)
            }
        }

        //Success...
    }

}