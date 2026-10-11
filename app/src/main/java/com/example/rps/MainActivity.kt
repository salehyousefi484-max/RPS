package com.example.rps

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private val choices = listOf("سنگ", "کاغذ", "قیچی")
    private var playerScore = 0
    private var phoneScore = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvResult = findViewById<TextView>(R.id.tvResult)
        val tvChoices = findViewById<TextView>(R.id.tvChoices)
        val tvScore = findViewById<TextView>(R.id.tvScore)

        fun play(player: Int) {
            val phone = Random.nextInt(3)

            // 0 = سنگ، 1 = کاغذ، 2 = قیچی
            val result = when {
                player == phone -> "مساوی شد"
                (player + 1) % 3 == phone -> { phoneScore++; "باختی 😅" }
                else -> { playerScore++; "بردی 🎉" }
            }

            tvChoices.text = "تو: ${choices[player]}  —  گوشی: ${choices[phone]}"
            tvResult.text = result
            tvScore.text = "تو: $playerScore  |  گوشی: $phoneScore"
        }

        findViewById<Button>(R.id.btnRock).setOnClickListener { play(0) }
        findViewById<Button>(R.id.btnPaper).setOnClickListener { play(1) }
        findViewById<Button>(R.id.btnScissors).setOnClickListener { play(2) }

        findViewById<Button>(R.id.btnReset).setOnClickListener {
            playerScore = 0
            phoneScore = 0
            tvResult.text = "انتخاب کن!"
            tvChoices.text = ""
            tvScore.text = "تو: 0  |  گوشی: 0"
        }
    }
}