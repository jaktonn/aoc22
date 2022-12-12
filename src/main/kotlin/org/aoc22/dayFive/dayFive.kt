package org.aoc22.dayFive

data class MoveInstruction(val howMany: Int, val from: Int, val to: Int) {

    companion object {
        fun fromLine(line: String): MoveInstruction {
            val regex = "move (\\d*) from (\\d*) to (\\d*)".toRegex()
            val (howMany, from, to) = regex.find(line)!!.destructured
            return MoveInstruction(howMany.toInt(), from.toInt(), to.toInt())
        }
    }

    fun execute(stack: List<MutableList<Char>>) {
        repeat(howMany) {
            val box = stack[from - 1].removeLast()
            stack[to - 1].add(box)
        }
    }

    fun executeOn9001(stack: List<MutableList<Char>>) {
        val onTheHook = mutableListOf<Char>()
        repeat(howMany) {
            onTheHook.add(0, stack[from - 1].removeLast())
        }
        stack[to - 1].addAll(onTheHook)
    }
}

fun parseStacks(): List<MutableList<Char>> {
    val stacks = listOf(
        mutableListOf<Char>(),
        mutableListOf(),
        mutableListOf(),
        mutableListOf(),
        mutableListOf(),
        mutableListOf(),
        mutableListOf(),
        mutableListOf(),
        mutableListOf()
    )
    scenario.forEach { line ->
        var nextMatch = 1
        var stackCounter = 0
        line.forEachIndexed { index, box ->
            if (index == nextMatch) {
                nextMatch += 4
                if (box != ' ') {
                    stacks[stackCounter].add(0, box)
                }
                stackCounter += 1
            }
        }
    }
    return stacks
}

fun main() {
    val stacksPart1 = parseStacks()
    println(stacksPart1)

    val moveInstructions = moves.map { MoveInstruction.fromLine(it) }
    println(moveInstructions)
    moveInstructions.forEach { moveInstruction -> moveInstruction.execute(stacksPart1) }
    println(stacksPart1)
    val topBoxes = stacksPart1.map { stack -> stack.last() }.joinToString("")
    println("Top layer of boxes, $topBoxes")

    val stacksPart2 = parseStacks()
    moveInstructions.forEach { moveInstruction -> moveInstruction.executeOn9001(stacksPart2) }
    println(stacksPart2)
    val nowOnTop = stacksPart2.map { stack -> stack.last() }.joinToString("")
    println("Top layer of boxes on 9001, $nowOnTop")
}