package com.example.cw01

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.viewbinding.ViewBinding
import com.example.cw01.databinding.Activity3Binding

class Activity3 : AppCompatActivity(), View.OnLongClickListener {

    lateinit var binding : Activity3Binding
    lateinit var button_dial: Button
    lateinit var et1: EditText

    fun runDial(phoneNum: String) {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phoneNum")
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_3)
        binding=Activity3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val activity3: View = findViewById(R.id.activity3)
        activity3.setOnLongClickListener(this)

        //button_dial = findViewById(R.id.button_dial)
        button_dial = binding.buttonDial

        button_dial.setOnClickListener { _ ->
            val str1 = et1.getText()
            runDial(str1.toString())
        }
    }


    override fun onStart() {
        super.onStart()
        val toast: Toast = Toast.makeText(this,
            "Activity 3 is started", Toast.LENGTH_LONG)
            //toast.setGravity(Gravity.CENTER,0,0)
        toast.show()
    }

    override fun onLongClick(view: View?): Boolean {
        onBackPressed(/*view: View*/)
        return true
    }

    fun finishActivity3(view:View) {
        onBackPressed()
    }

}