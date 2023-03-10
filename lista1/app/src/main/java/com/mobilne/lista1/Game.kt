package com.mobilne.lista1

class Game(private val mathOperation: MathOperation) {

    private var score = -1

    fun startGame(): Pair<String, MutableList<Int>>{
        this.score = -1
        return startRound()
    }

    fun startRound(): Pair<String,MutableList<Int>>{
        this.score++
        mathOperation.reset()
        val (operation, answers) = mathOperation.getData()
        return Pair(operation,answers)
    }

    fun getAnswer():Int{
        return mathOperation.getCorrectAnswer()
    }

    fun getOperation(): String{
        return mathOperation.getOperation()
    }

    fun getAnswers(): MutableList<Int>{
        return mathOperation.getAnswers()
    }

    fun getScore(): Int{
        return this.score
    }
}