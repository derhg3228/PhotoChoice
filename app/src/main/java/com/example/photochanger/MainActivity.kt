package com.example.photochanger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.photochanger.ui.common.isProfileAuth
import com.example.photochanger.ui.login.LoginFragment
import com.example.photochanger.ui.profile.ProfileFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        identifierUser()
    }

    private fun identifierUser() {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.container,
                if (isProfileAuth()) ProfileFragment()
                else LoginFragment()
            )
            .commit()

    }
}