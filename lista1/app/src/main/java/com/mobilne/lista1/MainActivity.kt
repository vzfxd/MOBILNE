package com.mobilne.lista1

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.mobilne.lista1.databinding.ActivityMainBinding
    private val mathOperation = MathOperation()
    private val game = Game(mathOperation)

class MainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(savedInstanceState != null){
            val score = savedInstanceState.getInt("score")
            val operation = savedInstanceState.getString("operation")
            val answers = savedInstanceState.getIntegerArrayList("answers")
            updateUI(operation!!,score, answers!!.toMutableList())
        }else{
            startGame()
        }
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        savedInstanceState.putInt("score",game.getScore())
        savedInstanceState.putString("operation",game.getOperation())
        savedInstanceState.putIntegerArrayList("answers", ArrayList(game.getAnswers()))
    }

    private fun startGame(){
        val (operation:String, answers:MutableList<Int>) = game.startGame()
        val score: Int = game.getScore()
        updateUI(operation,score,answers)
    }

    private fun startRound(){
        val (operation:String, answers:MutableList<Int>) = game.startRound()
        val score: Int = game.getScore()
        updateUI(operation,score,answers)
    }

    private fun updateUI(operation: String, score: Int, answers: MutableList<Int>) {
        binding.score.text = score.toString()
        binding.operation.text = operation
        binding.lbtn.text = answers[0].toString()
        binding.mbtn.text = answers[1].toString()
        binding.rbtn.text = answers[2].toString()
    }

    fun onClick(v: View){
        val button: Button = v as Button
        val num: Int = button.text.toString().toInt()

        if(num == game.getAnswer()) startRound() else startGame()

    }
}