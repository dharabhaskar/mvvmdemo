package com.dharabhaskar.mvvm.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.dharabhaskar.mvvm.R
import com.dharabhaskar.mvvm.data.db.User
import com.dharabhaskar.mvvm.databinding.ActivityLoginBinding
import com.dharabhaskar.mvvm.utils.toast
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(),AuthListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivityLoginBinding =DataBindingUtil.setContentView(this,R.layout.activity_login)
        val viewModel=ViewModelProviders.of(this).get(AuthViewModel::class.java)

        binding.viewmodel=viewModel
        viewModel.authListener=this
    }

    override fun onStarted() {
        progress.visibility= View.VISIBLE
    }

    override fun onSuccess(user:User?) {
        progress.visibility= View.GONE
        user?.let {
            toast("User Details:"+Gson().toJson(user))
        }
    }

    override fun onError(errMsg: String) {
        progress.visibility= View.GONE
        toast(errMsg)
    }

}
