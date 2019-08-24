package com.dharabhaskar.mvvm.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.dharabhaskar.mvvm.R
import com.dharabhaskar.mvvm.databinding.ActivityLoginBinding
import com.dharabhaskar.mvvm.utils.toast

class LoginActivity : AppCompatActivity(),AuthListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivityLoginBinding =DataBindingUtil.setContentView(this,R.layout.activity_login)
        val viewModel=ViewModelProviders.of(this).get(AuthViewModel::class.java)

        binding.viewmodel=viewModel
        viewModel.authListener=this
    }

    override fun onStarted() {
        toast("Login started")
    }

    override fun onSuccess() {
        toast("Login success")
    }

    override fun onError(errMsg: String) {
        toast(errMsg)
    }

}
