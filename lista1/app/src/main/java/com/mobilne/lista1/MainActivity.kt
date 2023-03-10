package com.mobilne.lista1

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.mobilne.lista1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding
    private val mathOperation = MathOperation()
    private val game = Game(mathOperation)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        startGame()
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
        val shuffledAnswers = answers.shuffled()
        binding.lbtn.text = shuffledAnswers[0].toString()
        binding.mbtn.text = shuffledAnswers[1].toString()
        binding.rbtn.text = shuffledAnswers[2].toString()
    }

    fun onClick(v: View){
        val button: Button = v as Button
        val num: Int = button.text.toString().toInt()

        if(num == game.getAnswer()) startRound() else startGame()

    }
}