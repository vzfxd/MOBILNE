package com.mobilne.lista1

class MathOperation{

    private var answers: MutableList<Int> = mutableListOf()
    private var correctAnswer: Int = 0
    private var operation: String = ""

    private fun rollOperation(){
        val possibleOperations: IntRange = 0..1
        val possibleNumbers: IntRange = 3..9
        val randomOperation: Int = possibleOperations.random()
        val val1: Int = possibleNumbers.random()
        val val2: Int = possibleNumbers.random()

        val operation: String
        val result: Int

        if(randomOperation==0){
            operation =  "$val1 + $val2"
            result = val1 + val2
        }else{
            operation =  "$val1 * $val2"
            result = val1 * val2
        }
        this.operation =  operation
        this.correctAnswer = result;
        this.answers.add(result)
    }

    private fun rollWrongAnswer() {
        val correctAnswer = this.answers[0]
        val bottomLim: Int = kotlin.math.floor(correctAnswer / 1.5).toInt()
        val topLim: Int = kotlin.math.ceil(correctAnswer * 1.5).toInt()

        val answersRange: IntRange = bottomLim..topLim

        var val1: Int = answersRange.random()

        while(val1 in this.answers) val1 = answersRange.random()

        this.answers.add(val1)
    }
    fun getCorrectAnswer(): Int{
        return this.correctAnswer
    }

    fun getAnswers(): MutableList<Int>{
        return this.answers
    }

    fun getOperation():String{
        return this.operation;
    }

    fun reset() {
        this.answers = mutableListOf()
        this.correctAnswer = 0
        this.operation = ""
    }

    fun getData():Pair<String,MutableList<Int>>{
        rollOperation()
        rollWrongAnswer()
        rollWrongAnswer()
        this.answers.shuffle()
        return Pair(this.operation,this.answers)
    }
}