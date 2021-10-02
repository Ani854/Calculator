package com.example.kotlincalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn00.setOnClickListener { appendOnClick(true, "00") }
        btn0.setOnClickListener { appendOnClick(true, "0") }
        btn1.setOnClickListener { appendOnClick(true, "1") }
        btn2.setOnClickListener { appendOnClick(true, "2") }
        btn3.setOnClickListener { appendOnClick(true, "3") }
        btn4.setOnClickListener { appendOnClick(true, "4") }
        btn5.setOnClickListener { appendOnClick(true, "5") }
        btn6.setOnClickListener { appendOnClick(true, "6") }
        btn7.setOnClickListener { appendOnClick(true, "7") }
        btn8.setOnClickListener { appendOnClick(true, "8") }
        btn9.setOnClickListener { appendOnClick(true, "9") }
        btnDot.setOnClickListener { appendOnClick(true, ".") }

        btnPlus.setOnClickListener { appendOnClick(false, "+") }
        btnMinus.setOnClickListener { appendOnClick(false, "-") }
        btnMultiply.setOnClickListener { appendOnClick(false, "*") }
        btnDivide.setOnClickListener { appendOnClick(false, "/") }
        btnLeftBracket.setOnClickListener { appendOnClick(false, "(") }
        btnRightBracket.setOnClickListener { appendOnClick(false, ")") }


        btnClear.setOnClickListener {
            clear()
        }

        btnEqual.setOnClickListener {
            calculate()
        }


    }
    private fun appendOnClick(clear: Boolean, string: String) {
        if (clear) {
            output.text = ""
            input.append(string)
        } else {
            input.append(output.text)
            input.append(string)
            output.text = ""
        }
    }

    private fun clear() {
        input.text = ""
        output.text = ""

    }

    private fun calculate() {
        try {
            val input1 = ExpressionBuilder(input.text.toString()).build()
            val output1 = input1.evaluate()
            val longOutput = output1.toLong()
            if (output1 == longOutput.toDouble()) {
                output.text = longOutput.toString()
            } else {
                output.text = output.toString()
            }

        } catch (e: Exception) {
            Toast.makeText(this@MainActivity, e.message, Toast.LENGTH_LONG).show()
        }
    }
}