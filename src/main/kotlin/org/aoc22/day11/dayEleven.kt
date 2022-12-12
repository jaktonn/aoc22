package org.aoc22.day11

import java.math.BigInteger


class Monkey(
    val number: Int,
    val items: MutableList<BigInteger>,
    val updateFunc: (old: BigInteger) -> BigInteger,
    val testDivisor: Int,
    val throwToIfTrue: Int,
    val throwToIfFalse: Int
) {

    var inspectCount: Long = 0

    companion object {

        private fun buildFunction(operator: String, secondArgument: String): (old: BigInteger) -> BigInteger {
            return if (secondArgument == "old") {
                when (operator) {
                    "*" -> { old: BigInteger -> old * old }
                    "+" -> { old: BigInteger -> old + old }
                    else -> throw RuntimeException()
                }
            } else {
                when (operator) {
                    "*" -> { old: BigInteger -> old * secondArgument.toBigInteger() }
                    "+" -> { old: BigInteger -> old + secondArgument.toBigInteger() }
                    else -> throw RuntimeException()
                }
            }
        }

        fun fromLines(lines: List<String>): Monkey {
            val number = lines[0].substringAfterLast(" ").substringBefore(":").toInt()
            val items = lines[1].substringAfterLast("Starting items:").split(",").map { it.trim().toBigInteger() }
            val functionElements = lines[2].substringAfterLast("Operation: new = old ").split(" ")
            val updateFunc = buildFunction(functionElements[0], functionElements[1])
            val testDivisor = lines[3].substringAfterLast(" ").toInt()
            val throwToIfTrue = lines[4].substringAfterLast(" ").toInt()
            val throwToIfFalse = lines[5].substringAfterLast(" ").toInt()
            return Monkey(number, items.toMutableList(), updateFunc, testDivisor, throwToIfTrue, throwToIfFalse)
        }
    }

    override fun toString(): String {
        return "Monkey(number=$number, items=$items, updateFunc=$updateFunc, testDivisor=$testDivisor, throwToIfTrue=$throwToIfTrue, throwToIfFalse=$throwToIfFalse)"
    }

    fun playRound(monkeys: List<Monkey>, worryDivisor: Int, allDivisors: Int) {
        while (items.isNotEmpty()) {
            val item = items.removeFirst()
            inspectCount += 1
            val updatedItemScore = updateFunc(item) % allDivisors.toBigInteger() / worryDivisor.toBigInteger()
            if (updatedItemScore % testDivisor.toBigInteger() == 0.toBigInteger()) {
                val monkey = monkeys[throwToIfTrue]
                monkey.items.add(updatedItemScore)
            } else {
                val monkey = monkeys[throwToIfFalse]
                monkey.items.add(updatedItemScore)
            }
        }
    }

}

fun main() {
    val monkeys = fullMonkeys.lines().chunked(7).map { Monkey.fromLines(it) }
    var allDivisors = monkeys.map { it.testDivisor }.reduceRight { d1, d2 -> d1 * d2 }

    repeat(20) {
        monkeys.forEach { it.playRound(monkeys, 3, allDivisors) }
    }

    val inspectCounts = monkeys.map { it.inspectCount }.sortedDescending()
    println(inspectCounts[0] * inspectCounts[1])

    val worrySomeMonkeys = fullMonkeys.lines().chunked(7).map { Monkey.fromLines(it) }
    allDivisors = worrySomeMonkeys.map { it.testDivisor }.reduceRight{ d1, d2 -> d1 * d2 }

    repeat(10000) {
        worrySomeMonkeys.forEach { it.playRound(worrySomeMonkeys, 1, allDivisors) }
    }

    val newInspectCounts = worrySomeMonkeys.map { it.inspectCount }.sortedDescending()
    println(newInspectCounts[0] * newInspectCounts[1])
}