package org.aoc22.day12

import kotlin.math.min

data class Position(val row: Int, val column: Int)

class Node(val row: Int, val column: Int, val height: Char) {
    var distance = Long.MAX_VALUE
    var visited = false

    fun visit(nodes: List<List<Node>>) {
        val neighbourCandidates = mutableListOf<Node>()
        if (row > 0) {
            neighbourCandidates.add(nodes[row - 1][column])
        }
        if (row < nodes.size -1) {
            neighbourCandidates.add(nodes[row + 1][column])
        }
        if (column > 0) {
            neighbourCandidates.add(nodes[row][column - 1])
        }
        if (column < nodes[nodes.size -1].size - 1) {
            neighbourCandidates.add(nodes[row][column + 1])
        }
        neighbourCandidates.forEach { neighbourCandidate ->
            if (!neighbourCandidate.visited && neighbourCandidate.height <= height + 1) {
                neighbourCandidate.distance = min(distance + 1, neighbourCandidate.distance)
            }
        }
        visited = true
    }

    override fun toString(): String {
        return "Node(row=$row, column=$column, height=$height, distance=$distance, visited=$visited)"
    }
}

fun getNodeHeight(row: Int, column: Int, char: Char): Char {
    return if (char == 'S') {
        'a'
    } else if (char == 'E') {
        'z'
    } else {
        char
    }
}

fun runDijkstra(map: List<String>, startPosition: Position, shortestDistanceSoFar: Long): Long {
    println("Starting at $startPosition")
    var endNode: Node? = null
    val nodes = map.mapIndexed { row, line ->
        line.mapIndexed { column, char  ->
            val node = Node(row, column, getNodeHeight(row, column, char))
            if (char == 'E') {
                endNode = node
            }
            node
        }
    }

    nodes[startPosition.row][startPosition.column].distance = 0

    val unvisitedNodes = nodes.flatten().sortedBy { it.distance }.toMutableList()
    var currentNode = unvisitedNodes.removeFirst()
    while ((currentNode.column != endNode!!.column || currentNode.row != endNode!!.row) && currentNode.distance < shortestDistanceSoFar) {
        currentNode.visit(nodes)
        unvisitedNodes.sortBy { it.distance }
        currentNode = unvisitedNodes.removeFirst()
    }
    return currentNode.distance
}

fun main() {
    val map = fullMap.lines()
    val startPosition = Position(map.indexOfFirst { line -> line.indexOf('S') >= 0}, map.map { line -> line.indexOf('S')}.first { it > -1})
    println(startPosition)

    val shortestPath = runDijkstra(map, startPosition, Long.MAX_VALUE)
    println("Shortest path from start square: $shortestPath")

    val startPositions = mutableListOf<Position>()
    map.forEachIndexed { row, line ->
        line.forEachIndexed { column, char ->
            if (char == 'S' || char == 'a') {
                startPositions.add(Position(row, column))
            }
        }
    }
    println(startPositions.size)

    // Note: This is fast to code, but slow to run - running Dijkstra backwards and
    // terminate once a node with height "a" is found would be way faster
    var shortestDistanceSoFar = shortestPath
    val shortestPossiblePath = startPositions.map {
        val newShortestDistance = runDijkstra(map, it, shortestDistanceSoFar)
        shortestDistanceSoFar = min(shortestDistanceSoFar, newShortestDistance)
        newShortestDistance
    }.min()
    println("Shortest possible path: $shortestPossiblePath")
}