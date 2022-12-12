package org.aoc22.dayFour

data class SectionRange(val start: Int, val end: Int) {

    companion object {
        fun fromString(st: String): SectionRange {
            val values = st.split('-').map { it.toInt() }.sorted()
            return SectionRange(values[0], values[1])
        }
    }

    fun containsFully(other: SectionRange): Boolean {
        return this.start <= other.start && this.end >= other.end
    }

    fun overlaps(other: SectionRange): Boolean {
        return IntRange(this.start, this.end).toSet().intersect(IntRange(other.start, other.end).toSet()).isNotEmpty()
    }
}

fun main() {
    val sectionPairs = input.map { line ->
        val pairs = line.split(',')
        listOf(SectionRange.fromString(pairs[0]), SectionRange.fromString(pairs[1]))
    }
    println(sectionPairs)
    val fullyIncludedSections = sectionPairs.count { pair ->
        pair[0].containsFully(pair[1]) || pair[1].containsFully(pair[0])
    }
    println("Fully contained pairs: $fullyIncludedSections")
    val overlappingPairs = sectionPairs.count { pair ->
        pair[0].overlaps(pair[1]) || pair[1].overlaps(pair[0])
    }
    println("Overlapping pairs: $overlappingPairs")
}