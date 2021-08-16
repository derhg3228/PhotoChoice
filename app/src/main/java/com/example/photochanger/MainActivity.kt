package com.example.photochanger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.photochanger.databinding.ActivityMainBinding
import com.example.photochanger.ui.LoginFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, LoginFragment())
            .commit()
    }
}