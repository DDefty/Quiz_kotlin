package com.dawid.quiz

object Constants {

    fun getQuestions(): ArrayList<Question> {
        val questionList = ArrayList<Question>()

        val question1 = Question(
            1,
            "Question 1 ",
            "1",
            "true",
            "3",
            "4",
            2
        )
        questionList.add(question1)
        val question2 = Question(
            2,
            "Question 1 ",
            "1",
            "true",
            "3",
            "4",
            2
        )
        questionList.add(question2)
        val question3 = Question(
            3,
            "Question 1 ",
            "1",
            "true",
            "3",
            "4",
            2
        )
        questionList.add(question3)
        val question4 = Question(
            4,
            "Question 1 ",
            "1",
            "true",
            "3",
            "4",
            2
        )
        questionList.add(question4)
        val question5 = Question(
            5,
            "Question 1 ",
            "1",
            "true",
            "3",
            "4",
            2
        )
        questionList.add(question5)

        return questionList

    }

}