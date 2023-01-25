package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val tvName:TextView=findViewById(R.id.tvName)
        val scoreCard:TextView=findViewById(R.id.scoreCard)
        val finishTheAcitvity:Button=findViewById(R.id.finishTheActivity)
        tvName.text=intent.getStringExtra(constants.USER_NAME)

        val totalQuestion=intent.getIntExtra(constants.TOTAL_QUESTION,0)
        val CorrectAns=intent.getIntExtra(constants.CORRECT_ANS,0)
        scoreCard.text="Your Score is $CorrectAns out of $totalQuestion"
        finishTheAcitvity.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }

    }
}