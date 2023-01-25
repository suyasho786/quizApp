package com.example.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.quizapp.R.*

class MainActivity2 : AppCompatActivity() {

    private var mCurrentPos=1
    private  var allbuttons: ArrayList<AppCompatButton>? =null
    private var mQuestionList:ArrayList<Question>?=null
    private var mSelectedOption:Int=0
    private var mUserName:String?=null
    private var Mcorrectans:Int=0
    private var Progressbar:ProgressBar?=null
    private var Tvprogressbar:TextView?=null
    private var tvquestion:TextView?=null
    private var questionImage:ImageView?=null
    private var submitBtn:Button?=null
    private var optionOne:TextView?=null
    private var optiontwo:TextView?=null
    private var optionthree:TextView?=null
    private var optionfour:TextView?=null
    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        mUserName=intent.getStringExtra(constants.USER_NAME)
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main2)
        Progressbar=findViewById(id.Progressbar)
        Tvprogressbar=findViewById(id.Tvprogressbar)
        tvquestion=findViewById(id.tvquestion)
        questionImage=findViewById(id.questionImage)
        optionOne=findViewById(id.optionone)
        optiontwo=findViewById(id.optiontwo)
        optionthree=findViewById(id.optionthree)
        optionfour=findViewById(id.optionfour)
        submitBtn=findViewById(R.id.submitBtn)
        val questionList=constants.getQuestions()
        Log.i("question size is","${questionList.size}")
        for (i in questionList){
            Log.e("Questinos",i.question)
        }

        allbuttons?.add(optionOne as AppCompatButton)
        allbuttons?.add(optiontwo as AppCompatButton)
        allbuttons?.add(optionthree as AppCompatButton)
        allbuttons?.add(optionfour as AppCompatButton)
        FirstWork(questionList)

    }

    private fun FirstWork(questionList: ArrayList<Question>) {
        submitBtn?.text="SUBMIT"
        var currentPos = mCurrentPos
        var buttonSelector = 1
        val question: Question = questionList[currentPos - 1]
        Progressbar?.progress = currentPos
        questionImage?.setImageResource(question.image)
        Tvprogressbar?.text = "$currentPos/${Progressbar?.max}"
        tvquestion?.text = question.question
        optionOne?.text = question.option1
        optiontwo?.text = question.option2
        optionthree?.text = question.option3
        optionfour?.text = question.option4


        optionOne?.setOnClickListener {
            buttonSelector = 1
            On(buttonSelector)
        }
        optiontwo?.setOnClickListener {
            buttonSelector = 2
            On(buttonSelector)
        }
        optionthree?.setOnClickListener {
            buttonSelector = 3
            On(buttonSelector)
        }
        optionfour?.setOnClickListener {
            buttonSelector = 4
            On(buttonSelector)
        }
        submitBtn?.setOnClickListener{
            if(submitBtn?.text=="GO TO THE NEXT QUESTION"){
                optionOne?.setBackgroundResource(R.drawable.gradient_bg)
                optiontwo?.setBackgroundResource(R.drawable.gradient_bg)
                optionthree?.setBackgroundResource(R.drawable.gradient_bg)
                optionfour?.setBackgroundResource(R.drawable.gradient_bg)
                FirstWork(questionList)
            }
            else if (submitBtn?.text=="FINISH") {
                val intent=Intent(this,MainActivity3::class.java)
                intent.putExtra(constants.USER_NAME,mUserName)
                intent.putExtra(constants.CORRECT_ANS,Mcorrectans)
                intent.putExtra(constants.TOTAL_QUESTION,questionList.size)
                startActivity(intent)
                finish()
//                Toast.makeText(this, "You made it !", Toast.LENGTH_LONG).show()
            }
          else  {

                if (buttonSelector == question.correctAns) {
                    CorrectAns(buttonSelector)
                } else {
                    WrongAns(buttonSelector, question.correctAns)
                }
                if (mCurrentPos == questionList.size) submitBtn?.text = "FINISH"

               else submitBtn?.text = "GO TO THE NEXT QUESTION"
                mCurrentPos++

            }

        }

    }

    private fun CorrectAns(selectedAns:Int){
        Mcorrectans++
        if(selectedAns==1)optionOne?.setBackgroundResource(R.drawable.correctans)
        if(selectedAns==2)optiontwo?.setBackgroundResource(R.drawable.correctans)
        if(selectedAns==3)optionthree?.setBackgroundResource(R.drawable.correctans)
        if(selectedAns==4)optionfour?.setBackgroundResource(R.drawable.correctans)
    }
    private fun WrongAns(selectedAns:Int,correctAns:Int){
        if(selectedAns==1)optionOne?.setBackgroundResource(R.drawable.wrongans)
        if(selectedAns==2)optiontwo?.setBackgroundResource(R.drawable.wrongans)
        if(selectedAns==3)optionthree?.setBackgroundResource(R.drawable.wrongans)
        if(selectedAns==4)optionfour?.setBackgroundResource(R.drawable.wrongans)

        if(correctAns==2)optiontwo?.setBackgroundResource(R.drawable.correctans)
        if(correctAns==1)optionOne?.setBackgroundResource(R.drawable.correctans)
        if(correctAns==3)optionthree?.setBackgroundResource(R.drawable.correctans)
        if(correctAns==4)optionfour?.setBackgroundResource(R.drawable.correctans)

    }


    private fun On(buttonSelector :Int){
        if(buttonSelector==1){
            optionOne?.setBackgroundResource(R.drawable.borederbutton)
        }else{
            optionOne?.setBackgroundResource(R.drawable.gradient_bg)
        }
        if(buttonSelector==2){
            optiontwo?.setBackgroundResource(R.drawable.borederbutton)
        }else{
            optiontwo?.setBackgroundResource(R.drawable.gradient_bg)
        }
        if(buttonSelector==3){
            optionthree?.setBackgroundResource(R.drawable.borederbutton)
        }else{
            optionthree?.setBackgroundResource(R.drawable.gradient_bg)
        }
        if(buttonSelector==4){
            optionfour?.setBackgroundResource(R.drawable.borederbutton)
        }else{
            optionfour?.setBackgroundResource(R.drawable.gradient_bg)
        }
    }


}
