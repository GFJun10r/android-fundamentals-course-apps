package com.gfjun10r.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var firstDiceImage: ImageView
    private lateinit var secondDiceImage: ImageView
    private lateinit var resetButton: Button
    private lateinit var rollButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rollButton = findViewById(R.id.roll_button)
        resetButton = findViewById(R.id.reset_button)
        secondDiceImage = findViewById(R.id.second_dice_image)
        firstDiceImage = findViewById(R.id.first_dice_image)

        resetButton.setOnClickListener { resetResult() }
        rollButton.setOnClickListener { rollDices() }
    }

    private fun rollDices() {
        secondDiceImage.setImageResource(rollDice())
        firstDiceImage.setImageResource(rollDice())
    }

    private fun rollDice() = when ((1..6).random()) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }


    private fun resetResult() {
        firstDiceImage.setImageResource(R.drawable.empty_dice)
        secondDiceImage.setImageResource(R.drawable.empty_dice)
    }
}
