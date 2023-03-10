package com.mobilne.lista1

class Game(val mathOperation: MathOperation) {
    private var score: Int = -1
    private var answer: Int = 0

    fun startGame(): Pair<String, MutableList<Int>>{
        this.score = -1
        return startRound()
    }

    fun startRound(): Pair<String,MutableList<Int>>{
        this.score++
        mathOperation.reset()
        val (operation, answers) = mathOperation.getData()
        this.answer = answers[0]
        return Pair(operation,answers)
    }

    fun getScore(): Int{
        return this.score
    }

    fun getAnswer():Int{
        return this.answer
    }
}