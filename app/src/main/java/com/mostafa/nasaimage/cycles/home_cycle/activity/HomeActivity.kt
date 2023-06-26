package com.mostafa.nasaimage.cycles.home_cycle.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mostafa.nasaimage.R
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }
}