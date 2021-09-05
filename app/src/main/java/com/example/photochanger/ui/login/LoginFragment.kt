package com.example.photochanger.ui.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.photochanger.R
import com.example.photochanger.databinding.FragmentLoginBinding
import com.example.photochanger.ui.common.BaseFragment
import com.example.photochanger.isProfileAuth
import com.example.photochanger.ui.profile.ProfileFragment
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginResult

class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {

    private lateinit var callbackManager: CallbackManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        callbackManager = CallbackManager.Factory.create()

        binding.loginButton.fragment = this
        binding.loginButton.registerCallback(callbackManager,
            object : FacebookCallback<LoginResult>{
                override fun onSuccess(result: LoginResult?) {
                    Log.e("onSuccessFacebook", result!!.accessToken.toString())
                    if (isProfileAuth()) openProfile()
                }

                override fun onCancel() {
                    Log.e("OnCancelFacebook", "onCancel")
                }

                override fun onError(error: FacebookException?) {
                    Log.e(this::class.simpleName, "FAILED LOGIN: ${error!!.message}")
                }

            }
        )
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        callbackManager.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)
    }

    private fun openProfile(){
        parentFragmentManager.beginTransaction()
            .replace(R.id.container, ProfileFragment())
            .commit()
    }
}