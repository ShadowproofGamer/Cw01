package com.example.cw01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import android.widget.ImageView
import android.widget.Switch

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        img1 = findViewById(R.id.img1)
        val sw: Switch = findViewById(R.id.switch1)
        sw.setChecked(true)
        sw.setOnCheckedChangeListener(swListener)
    }

    lateinit var img1:ImageView

    val swListener = CompoundButton.OnCheckedChangeListener { _, isChecked ->
        if (isChecked)
            img1.setVisibility(View.VISIBLE)
        else
            img1.setVisibility(View.INVISIBLE)
    }
}