package com.example.pupa

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pupa.databinding.ActivityConverterBinding
import com.example.pupa.CalculatorActivity

class ConverterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityConverterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityConverterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Градусы -> Радианы
        binding.buttonDegrees.setOnClickListener {

            val degrees = binding.editDegrees.text.toString().toDouble()

            val radians = degrees * Math.PI / 180

            binding.textRadians.text = radians.toString()
        }

        // Километры -> Мили
        binding.buttonKm.setOnClickListener {

            val km = binding.editKm.text.toString().toDouble()

            binding.textMiles.text = (km * 0.62).toString()
        }

        // Метры -> Футы
        binding.buttonMeters.setOnClickListener {

            val meters = binding.editMeters.text.toString().toDouble()

            binding.textFeet.text = (meters * 3.28).toString()
        }

        // Decimal -> Hex
        binding.buttonHex.setOnClickListener {

            val number = binding.editHex.text.toString().toInt()

            binding.textHex.text =
                Integer.toHexString(number).uppercase()
        }

        // Decimal -> Binary
        binding.buttonBinary.setOnClickListener {

            val number = binding.editBinary.text.toString().toInt()

            binding.textBinary.text =
                Integer.toBinaryString(number).uppercase()
        }

        // Переход к калькулятору
        binding.buttonCalculator.setOnClickListener {

            val intent =
                Intent(this, CalculatorActivity::class.java)

            startActivity(intent)
        }
    }
}