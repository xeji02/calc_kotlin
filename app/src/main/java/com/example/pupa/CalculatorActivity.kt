package com.example.pupa

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pupa.databinding.ActivityCalculatorBinding

class CalculatorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCalculatorBinding

    private var firstNumber = 0.0
    private var operation = ""
    private var newNumber = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState != null) {

            binding.textDisplay.text =
                savedInstanceState.getString("display")

            firstNumber =
                savedInstanceState.getDouble("firstNumber")

            operation =
                savedInstanceState.getString("operation", "")

            newNumber =
                savedInstanceState.getBoolean("newNumber")
        }

        binding.button0.setOnClickListener { appendDigit("0") }
        binding.button1.setOnClickListener { appendDigit("1") }
        binding.button2.setOnClickListener { appendDigit("2") }
        binding.button3.setOnClickListener { appendDigit("3") }
        binding.button4.setOnClickListener { appendDigit("4") }
        binding.button5.setOnClickListener { appendDigit("5") }
        binding.button6.setOnClickListener { appendDigit("6") }
        binding.button7.setOnClickListener { appendDigit("7") }
        binding.button8.setOnClickListener { appendDigit("8") }
        binding.button9.setOnClickListener { appendDigit("9") }

        binding.buttonPlus.setOnClickListener {
            setOperation("+")
        }

        binding.buttonMinus.setOnClickListener {
            setOperation("-")
        }

        binding.buttonMultiply.setOnClickListener {
            setOperation("*")
        }

        binding.buttonDivide.setOnClickListener {
            setOperation("/")
        }

        binding.buttonEquals.setOnClickListener {
            calculate()
        }

        binding.buttonClear.setOnClickListener {

            binding.textDisplay.text = "0"
            firstNumber = 0.0
            operation = ""
            newNumber = true
        }
    }

    private fun appendDigit(digit: String) {

        if (newNumber) {
            binding.textDisplay.text = digit
            newNumber = false
        } else {
            binding.textDisplay.append(digit)
        }
    }

    private fun setOperation(op: String) {

        firstNumber = binding.textDisplay.text.toString().toDouble()
        operation = op
        newNumber = true
    }

    private fun calculate() {

        val secondNumber =
            binding.textDisplay.text.toString().toDouble()

        val result = when (operation) {

            "+" -> firstNumber + secondNumber
            "-" -> firstNumber - secondNumber
            "*" -> firstNumber * secondNumber
            "/" -> firstNumber / secondNumber
            else -> secondNumber
        }

        binding.textDisplay.text = result.toString()

        firstNumber = result
        newNumber = true
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putString(
            "display",
            binding.textDisplay.text.toString()
        )

        outState.putDouble(
            "firstNumber",
            firstNumber
        )

        outState.putString(
            "operation",
            operation
        )

        outState.putBoolean(
            "newNumber",
            newNumber
        )
    }
}