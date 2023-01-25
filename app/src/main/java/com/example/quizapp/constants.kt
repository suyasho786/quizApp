package com.example.quizapp

object constants {

    const val USER_NAME:String="user_name"
    const val TOTAL_QUESTION:String="total_questions"
    const val CORRECT_ANS:String="correct_ans"

    fun getQuestions():ArrayList<Question>{
        val questinoList=ArrayList<Question>()

        val q1=Question(
            1,"What is Name of this language",
            R.drawable.python,
            "C++",
            "JAVA",
            "KOTLIN",
            "PYTHON",
            4
        )
        questinoList.add(q1)
        val q2=Question(
            1,"What is Name of this language",
            R.drawable.java,
            "GO",
            "JAVA",
            "RUBY",
            "C#",
            2
        )
        questinoList.add(q2)
        val q3=Question(
            1,"What is Name of this language",
            R.drawable.ruby_pic,
            "GOLANG",
            "JAVASCRIPT",
            "RUBY",
            "C++TURBO",
            3
        )
        questinoList.add(q3)

        return questinoList
    }
}