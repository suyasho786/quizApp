package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonStart : Button =findViewById(R.id.buttonStart)
        val edText :EditText=findViewById(R.id.edText)
        buttonStart.setOnClickListener {
            if(edText.text.isEmpty()){
                Toast.makeText(this,"Please Enter Your Name",Toast.LENGTH_LONG).show()
            }else{
                val intent=Intent(this,MainActivity2::class.java)
                intent.putExtra(constants.USER_NAME,edText.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}