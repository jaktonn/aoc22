package org.aoc22.day8

import kotlin.math.max
import kotlin.math.min

fun isVisible(trees: List<String>, row: Int, column: Int): Boolean {
    val columnString = trees.fold("") { columnSt, line ->
        columnSt + line[column]
    }
    return trees[row].substring(0, column).none { it >= trees[row][column] }
            || trees[row].substring(column + 1).none { it >= trees[row][column] }
            || columnString.substring(0, row).none { it >= trees[row][column] }
            || columnString.substring(row + 1).none { it >= trees[row][column] }
}

fun visibleTreeCount(tree: Char, treesInDirection: String): Int {
    val firstTreeIndex = treesInDirection.indexOfFirst { it >= tree }
    return if (firstTreeIndex == -1) {
        treesInDirection.length
    } else {
        firstTreeIndex + 1
    }
}

fun visibleTreeCount(trees: List<String>, row: Int, column: Int): Int {
    val columnString = trees.fold("") { columnSt, line ->
        columnSt + line[column]
    }
    return visibleTreeCount(
        trees[row][column],
        trees[row].substring(0, max(column, 0)).reversed()
    ) * visibleTreeCount(trees[row][column], trees[row].substring(min(column + 1, trees[row].length))) *
            visibleTreeCount(trees[row][column], columnString.substring(0, max(row, 0)).reversed()) *
            visibleTreeCount(trees[row][column], columnString.substring(min(row + 1, columnString.length)))

}

fun main() {
    val trees = treeMap
    var visibleTrees = trees.size * 2 + (trees[0].length - 2) * 2 // circumference trees
    for (i in 1 until trees.size - 1) {
        for (j in 1 until trees[i].length - 1) {
            if (isVisible(trees, i, j)) {
                visibleTrees += 1
            }
        }
    }
    println(visibleTrees)

    val visibilityMap = trees.mapIndexed { i, treeRow ->
        treeRow.mapIndexed { j, _ ->
            visibleTreeCount(trees, i, j)
        }
    }
    val maxVisibility = visibilityMap.maxOf { it.max() }
    println(maxVisibility)
}