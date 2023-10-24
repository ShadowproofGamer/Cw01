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
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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

    val startCalcForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult())
        { result: ActivityResult ->
            if (result.resultCode == RESULT_OK) {
            // Handle the Intent:
                val intent = result.data // the same is: intent = result.getData()
                val d = intent?.getIntExtra("result",999) //result is id key for data //999 – default value

                if (d != null) {
                    val str = d.toString()
                    val tvResult: TextView = findViewById(R.id.tv_result)
                    tvResult.setText(str)
                }
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
        et1 = binding.et1

        button_dial.setOnClickListener { _ ->
            val str1 = et1.getText()
            runDial(str1.toString())
        }

        val button_calc = binding.buttonCalc
        var et_val1 = binding.etVal1
        var et_val2 = binding.etVal2
        var aBundle = Bundle()
        button_calc.setOnClickListener { view:View ->
            aBundle.putInt("val1",et_val1.text.toString().toInt())
            aBundle.putInt("val2",et_val2.text.toString().toInt())
            val intent = Intent(this, ActivityCalc::class.java)
            intent.putExtras(aBundle)
            startCalcForResult.launch(intent)
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