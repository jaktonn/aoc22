package org.aoc22.day10



fun main() {
    val programm = fullProgramm
    val registerValues = mutableListOf<Int>()

    val instructionIterator = programm.iterator()
    var currentRegisterValue = 1
    while(instructionIterator.hasNext()) {
        val commands = instructionIterator.next().split(" ")
        if (commands[0] == "addx") {
            registerValues.add(currentRegisterValue)
            registerValues.add(currentRegisterValue)
            currentRegisterValue += commands[1].toInt()
        } else {
            registerValues.add(currentRegisterValue)
        }
    }
    val relevantSteps = listOf(20, 60, 100, 140, 180, 220)
    val signalStengthSum = relevantSteps.map { registerValues[it - 1] * it }.sum()
    println(signalStengthSum)

    registerValues.chunked(40).forEach { row ->
        val rowString = row.mapIndexed() { index, value ->
            if (index in (value - 1 .. value + 1) ) {
                "#"
            } else {
                "."
            }
        }.joinToString("")
        println(rowString)
    }
}