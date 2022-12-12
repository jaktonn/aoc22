package org.aoc22.day9

import kotlin.math.abs
import kotlin.math.sign

data class Position(val x: Int, val y: Int) {
    fun follow(head: Position): Position {
        val touches = abs(head.x - x) <= 1 && abs(head.y - y) <= 1
        return if (touches) {
            this
        } else {
            Position(x + (head.x - x).sign, y + (head.y - y).sign)
        }
    }
}

data class RopeSpec(val headPosition: Position, val tailPosition: Position) {


    private fun moveInDirection(direction: String): RopeSpec {
        val newHead = when (direction) {
            "R" -> Position(headPosition.x + 1, headPosition.y)
            "L" -> Position(headPosition.x - 1, headPosition.y)
            "U" -> Position(headPosition.x, headPosition.y - 1)
            "D" -> Position(headPosition.x, headPosition.y + 1)
            else -> headPosition
        }
        val newTail = tailPosition.follow(newHead)
        return RopeSpec(newHead, newTail)
    }

    fun move(move: String): List<RopeSpec> {
        val (direction, count) = move.split(" ")
        val ropeSpecs = mutableListOf<RopeSpec>()
        ropeSpecs.add(this.moveInDirection(direction))
        repeat(count.toInt() - 1 ) {
            ropeSpecs.add(ropeSpecs.last().moveInDirection(direction))
        }
        return ropeSpecs
    }
}

data class SegmentRope(val headPosition: Position, val tails: List<Position>) {

    private fun moveInDirection(direction: String): SegmentRope {
        val newHead = when (direction) {
            "R" -> Position(headPosition.x + 1, headPosition.y)
            "L" -> Position(headPosition.x - 1, headPosition.y)
            "U" -> Position(headPosition.x, headPosition.y - 1)
            "D" -> Position(headPosition.x, headPosition.y + 1)
            else -> headPosition
        }
        val newTails = tails.fold(emptyList<Position>()) { tailList, tail ->
            val predecessor = tailList.lastOrNull() ?: newHead
            tailList + tail.follow(predecessor)
        }
        return SegmentRope(newHead, newTails)
    }

    fun move(move: String): List<SegmentRope> {
        val (direction, count) = move.split(" ")
        val ropeMoves = mutableListOf<SegmentRope>()
        ropeMoves.add(this.moveInDirection(direction))
        repeat(count.toInt() - 1) {
            ropeMoves.add(ropeMoves.last().moveInDirection(direction))
        }
        return ropeMoves
    }
}

fun printPath(positions: Set<Position>) {
    // Print function added later, just for fun :)
    val minX = positions.minOf { it.x }
    val maxX = positions.maxOf { it.x }
    val minY = positions.minOf { it.y }
    val maxY = positions.maxOf { it.y }
    for (y in minY .. maxY) {
        for (x in minX .. maxX) {
            if (positions.contains(Position(x, y))) {
                print("#")
            } else {
                print(".")
            }
        }
        println()
    }
}

fun main() {
    val moves = fullPuzzle
    val initialRopeSpec = RopeSpec(Position(0,0), Position(0, 0))
    val tailPositions = mutableSetOf<Position>()
    moves.fold(initialRopeSpec) { currentRopeSpec, move ->
        val newSpecs = currentRopeSpec.move(move)
        tailPositions.addAll(newSpecs.map { it.tailPosition})
        newSpecs.last()
    }
    println(tailPositions.size)

    val longTailPositions = mutableSetOf<Position>()
    val initialSegmentRope = SegmentRope(Position(0, 0), generateSequence { Position(0,0) }.take(9).toList())
    moves.fold(initialSegmentRope) {currentSegmentRope, move ->
        val newSegmentRopes = currentSegmentRope.move(move)
        println(newSegmentRopes.last())
        longTailPositions.addAll(newSegmentRopes.map { it.tails.last() })
        newSegmentRopes.last()
    }
    println(longTailPositions.size)
    printPath(longTailPositions)
}