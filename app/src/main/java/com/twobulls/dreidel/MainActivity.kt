package com.twobulls.dreidel

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.util.Random

class MainActivity : AppCompatActivity() {
    var count = 0
    var lastLetter = '?'

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_spin).setOnClickListener {
            val letter = when (Random().nextInt(4)) {
                0 -> 'ש'
                1 -> 'ה'
                2 -> 'ג'
                3 -> 'נ'
                else -> '?'
            }
            val description = when(letter) {
                'ש' -> "Share a drink in the middle cup (unless the glass is full then finish it)"
                'ה' -> "Have a drink"
                'ג' -> "Get the drink in the middle and finish it (unless its empty, then share a drink)"
                'נ' -> "Nothing happens"
                else -> "Fuck it mensly made a bug"
            }
            val threeInARow = when(letter) {
                'ש' -> "You and the other two share into the cup until its full"
                'ה' -> "Everyone in the game has a drink"
                'ג' -> "You and the other two remove an item of clothing"
                'נ' -> "You and the other two finish your drinks"
                else -> "Fuck it mensly made a bug"
            }
            if (letter == lastLetter) {
                count++
            }
            else {
                count = 0
            }
            findViewById<TextView>(R.id.letter).text = letter.toString()
            findViewById<TextView>(R.id.description).text = description
            findViewById<TextView>(R.id.three_in_a_row).apply {
                visibility = if (count >= 2) View.VISIBLE else View.GONE
                text = threeInARow
            }
        }
    }
}
