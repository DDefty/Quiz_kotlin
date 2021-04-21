package com.dawid.quiz

object Constants {

    fun getQuestions(): ArrayList<Question> {
        val questionList = ArrayList<Question>()

        val question1 = Question(
            1,
            "Question 1 ",
            "1",
            "2",
            "3",
            "4",
            2
        )
        questionList.add(question1)
        val question2 = Question(
            2,
            "Question 2 ",
            "1",
            "2",
            "3",
            "4",
            2
        )
        questionList.add(question2)
        val question3 = Question(
            3,
            "Question 3 ",
            "1",
            "2",
            "3",
            "4",
            2
        )
        questionList.add(question3)
        val question4 = Question(
            4,
            "Question 4 ",
            "1",
            "2",
            "3",
            "4",
            2
        )
        questionList.add(question4)
        val question5 = Question(
            5,
            "Question 5 ",
            "1",
            "2",
            "3",
            "4",
            2
        )
        questionList.add(question5)
        questionList.shuffle()

        return questionList

    }

}