package com.dawid.quiz

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_questions.*

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mResult: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mQuestionList = Constants.getQuestions()
        setQuestion()

        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)
        btn_submit.setOnClickListener(this)
    }
    @SuppressLint("SetTextI18n")
    private fun setQuestion(){

        val question = mQuestionList!!.get(mCurrentPosition-1)

        defaultOptionsView()

        if(mCurrentPosition == mQuestionList!!.size){
            btn_submit.text="Finish"
        }
        else{
            btn_submit.text="Submit"
        }

        progressBar.progress = mCurrentPosition
        progressBar.max = mQuestionList!!.size
        tv_progress.text = "$mCurrentPosition" + "/" + mQuestionList!!.size
        tv_result.text = "Result :" + "$mResult"
        tv_question.text = question.question
        tv_option_one.text = question.optionOne
        tv_option_two.text = question.optionTwo
        tv_option_three.text = question.optionThree
        tv_option_four.text = question.optionFour

    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.tv_option_one -> {
                    selectedOptionView(tv_option_one, 1)
                }
                R.id.tv_option_two -> {
                    selectedOptionView(tv_option_two, 2)
                }
                R.id.tv_option_three -> {
                    selectedOptionView(tv_option_three, 3)
                }
                R.id.tv_option_four -> {
                    selectedOptionView(tv_option_four, 4)
                }


                R.id.btn_submit -> {
                    if (mSelectedOptionPosition == 0) {
                        when {
                            mCurrentPosition <= mQuestionList!!.size -> {
                                setQuestion()
                            }
                            else -> {
                                Toast.makeText(
                                    this, "You've completed the quiz with result : $mResult", Toast.LENGTH_SHORT
                                ).show()
                                val intent = Intent(this, MainActivity::class.java)
                                startActivity(intent)

                            }
                        }
                    } else {
                        val question = mQuestionList?.get(mCurrentPosition - 1)
                        if (question!!.correctOption != mSelectedOptionPosition) {

                            answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                        }
                        else{
                            mResult += 1
                        }
                        answerView(question.correctOption, R.drawable.correct_option_border_bg)
                        if (mCurrentPosition == mQuestionList!!.size) {
                            btn_submit.text = "Finish"
                        } else {
                            btn_submit.text = "Next question"
                        }
                        mSelectedOptionPosition = 0
                        mCurrentPosition += 1
                    }
                }

            }

        }
    }


    private fun defaultOptionsView(){

        val options = ArrayList<TextView>()
        options.add(0,tv_option_one)
        options.add(1,tv_option_two)
        options.add(2,tv_option_three)
        options.add(3,tv_option_four)

        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this, R.drawable.default_option_border_bg
            )
        }

    }

    private fun selectedOptionView(tv: TextView,selectedOptionNum: Int){

        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this,
        R.drawable.selected_option_border_bg)
    }

    private fun answerView(answer: Int, drawableView: Int){

        when(answer){

            1 -> {
                tv_option_one.background = ContextCompat.getDrawable(this, drawableView)
            }
            2 -> {
                tv_option_two.background = ContextCompat.getDrawable(this, drawableView)
            }
            3 -> {
                tv_option_three.background = ContextCompat.getDrawable(this, drawableView)
            }
            4 -> {
                tv_option_four.background = ContextCompat.getDrawable(this, drawableView)
            }
        }
    }

}