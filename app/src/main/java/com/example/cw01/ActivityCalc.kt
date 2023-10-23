package com.example.cw01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cw01.databinding.ActivityCalcBinding

class ActivityCalc : AppCompatActivity() {

    lateinit var binding:ActivityCalcBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_calc)

        binding = ActivityCalcBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val iii: Intent = getIntent()
        val bundle = iii.extras
        var val1:Int = bundle?.getInt("val1",1) ?: 0
        var val2:Int = bundle?.getInt("val2",1) ?: 0

        val buttonAdd = binding.buttonAdd
        buttonAdd.setOnClickListener { _ ->
            val sum = val1 + val2
            iii.putExtra("result",sum)
            setResult(RESULT_OK, iii)
            finish()
        }

        val buttonSubtract = binding.buttonSubtract
        buttonSubtract.setOnClickListener { _ ->
            val sum = val1 - val2
            iii.putExtra("result",sum)
            setResult(RESULT_OK, iii)
            finish()
        }

        val buttonMultiply = binding.buttonMultiply
        buttonMultiply.setOnClickListener { _ ->
            val sum = val1 * val2
            iii.putExtra("result",sum)
            setResult(RESULT_OK, iii)
            finish()
        }

    }
}