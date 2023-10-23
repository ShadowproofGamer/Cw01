package com.example.cw01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() , View.OnClickListener{
    override fun onClick(view: View?) {
        val myIntent = Intent(this, Activity3::class.java)
        startActivity(myIntent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1: Button = findViewById(R.id.button1)
        button1.setOnClickListener { _ ->
            val myIntent = Intent(this, Activity2::class.java)
            startActivity(myIntent)
        }

        val button2: Button = findViewById(R.id.button2)
        button2.setOnClickListener(this)

        val button4: Button = findViewById(R.id.button4)
        button4.setOnClickListener(myListener)

    }

    val myListener = View.OnClickListener { view ->
        when (view.getId()) {
            R.id.button4 -> {
                val myIntent = Intent(this, Activity3::class.java)
                startActivity(myIntent)
            }
        }
    }

    fun run2(view: View) {
        val myIntent = Intent(this, Activity2::class.java)
        startActivity(myIntent)
    }

}