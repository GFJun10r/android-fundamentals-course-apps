package com.gfjun10r.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }
        val countUpButton: Button = findViewById(R.id.count_up_button)
        countUpButton.setOnClickListener { countUp() }
    }

    private fun countUp() {
        val resultText: TextView = findViewById(R.id.result_text)
        val inicialText = getString(R.string.initial_result_text)

        if (resultText.text.toString() == inicialText) {
            resultText.text = "1"
        } else {
            var diceValue = resultText.text.toString().toInt()

            if (diceValue < 6) {
                diceValue++
                resultText.text = diceValue.toString()
            } else {
                Toast.makeText(this, "Dice reached max value...", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun rollDice() {
        val resultText: TextView = findViewById(R.id.result_text)
        val randomInt = (1..6).random()
        resultText.text = randomInt.toString()
    }
}
