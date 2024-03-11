package com.example.travelconsuption

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.travelconsuption.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonCalculate.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        if (view.id == R.id.buttonCalculate) {
            calculate()
        }
    }

    private fun isValid(): Boolean {
        return (binding.editDistance.text.toString() != ""
                && binding.editPreco.text.toString() != ""
                && binding.editAutonomia.text.toString() != ""

                )
    }

    private fun calculate() {
        if (isValid()) {
            val distance = binding.editDistance.text.toString().toFloat()
            val price = binding.editPreco.text.toString().toFloat()
            val autonomy = binding.editAutonomia.text.toString().toFloat()
            if (autonomy == 0f) {
                Toast.makeText(this, R.string.no_div_zero, Toast.LENGTH_SHORT).show()
                binding.textRes.text = "R$ 0"

            } else {
                val totalValue = (price * distance) / autonomy

                binding.textRes.text = "R$ ${"%.2f".format(totalValue)}"
            }
        } else {
            Toast.makeText(this, R.string.validation_fill_all_filds, Toast.LENGTH_SHORT).show()

        }

    }
}