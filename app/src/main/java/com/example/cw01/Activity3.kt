package com.example.cw01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast

class Activity3 : AppCompatActivity(), View.OnLongClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_3)


        val activity3: View = findViewById(R.id.activity3)
        activity3.setOnLongClickListener(this)
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