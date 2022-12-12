package org.aoc22.daytwo

val strategyGuide = """
    C Y
    C Z
    C Z
    C Z
    A Y
    C Z
    C Z
    B Y
    C Y
    A X
    C Z
    A Z
    C Y
    C Z
    C Z
    B X
    A Z
    C Z
    C Z
    C Z
    A Z
    B X
    C Y
    C Z
    C Z
    C Z
    C Y
    C Z
    C Z
    C Z
    C Z
    C Z
    A Z
    B X
    A Z
    C Z
    C Z
    C Z
    C Z
    A Z
    A X
    B X
    C Y
    A Z
    A Z
    C Y
    A Z
    A Z
    C Y
    A Z
    B X
    A Z
    C Z
    B X
    C Y
    C Z
    C Z
    B Z
    C Y
    C Z
    A Z
    C X
    C Z
    B X
    B Y
    C Z
    C Z
    C Y
    A Z
    C Y
    C Y
    B X
    A Z
    B Z
    C Z
    C Z
    C Z
    B X
    A X
    B Y
    C Z
    C Y
    C Y
    A Z
    A Z
    C Z
    C Z
    C Z
    A X
    A X
    C Y
    C Z
    A Z
    C Y
    A Z
    A Z
    C Z
    A Z
    C Y
    C Z
    A Z
    A X
    C Z
    C Z
    A Z
    B Y
    A Z
    B X
    C Z
    C Y
    A X
    C Z
    C Y
    C Z
    C Z
    B Y
    C Z
    A Z
    C Z
    B X
    C Z
    C Y
    A Z
    B Y
    B X
    B X
    A X
    B X
    A Z
    B X
    A Y
    A X
    A Z
    A Z
    C Y
    B X
    C Z
    C Z
    A X
    A Z
    A Y
    B X
    A Y
    A Z
    C Z
    A X
    C Z
    C Z
    C Z
    B X
    C Z
    C Y
    C Y
    C Z
    A Z
    C Z
    B X
    A Z
    C Y
    A X
    A Z
    A Y
    C Z
    A Z
    C Z
    C Z
    A Z
    C Y
    A Z
    C Z
    A Z
    C Z
    B X
    C Z
    A Z
    C Z
    C X
    B Y
    A Z
    C Z
    C Y
    C Z
    A Z
    C Y
    B Z
    A X
    A Z
    B X
    C Y
    C Z
    B X
    C Y
    C Y
    A Z
    B X
    C Y
    C Y
    A Z
    C X
    B X
    B Y
    C Y
    C Z
    B X
    C Z
    A Z
    A Z
    B X
    B X
    C Y
    C Z
    B X
    C Z
    A Z
    B X
    C Y
    C Z
    C Z
    A X
    B X
    A Z
    C Z
    A X
    C Y
    B Y
    B X
    C Z
    C Y
    C Y
    A Y
    C Z
    C Y
    C Z
    C Z
    A Z
    C Z
    C Y
    A Z
    C Y
    C Z
    C Y
    C X
    B X
    A X
    B X
    C Z
    A Z
    C Y
    C Z
    B X
    C X
    B X
    C Z
    C Z
    C Y
    B X
    C Z
    A Y
    C Z
    A X
    C Z
    C Z
    C Y
    C Z
    C X
    B X
    C Z
    C Z
    C Y
    B Y
    C Z
    A X
    C X
    C Y
    A Z
    C X
    A Z
    C Y
    C Z
    C Z
    B X
    A X
    C Z
    B X
    C Y
    B X
    A X
    A Z
    A Z
    C Z
    C Z
    B X
    C Z
    A Z
    C X
    C Z
    C Z
    C Z
    C Y
    C Y
    A Z
    C Z
    C Z
    C Z
    C Z
    C Z
    C Z
    C Z
    C Z
    C Z
    A Z
    C Z
    C Y
    C Y
    A Z
    C Z
    A Z
    A X
    C Z
    C Y
    C Z
    C Z
    C Z
    C Z
    C Y
    C Z
    A Z
    B X
    A X
    B X
    A Y
    C Z
    C Y
    A Z
    C X
    C Z
    C Z
    C Z
    C Z
    C Y
    A X
    B Z
    A Z
    C Z
    A X
    C Z
    C Z
    A Z
    C Z
    C Z
    A Z
    C Z
    B X
    C Z
    A X
    C Y
    A Z
    B X
    B X
    C Z
    B Z
    C Z
    B X
    C Y
    B X
    C Y
    A Z
    A Y
    A Z
    C Z
    C Z
    A Z
    C Z
    A X
    A Z
    C Y
    A X
    C Y
    C Z
    C Z
    C Z
    A X
    C Y
    A Z
    A Z
    A X
    C Z
    C Z
    B Y
    A X
    C Y
    C Y
    C Z
    C Z
    A Z
    A Z
    C Y
    C Z
    A Z
    C Y
    C Z
    A Z
    C Z
    A Z
    C Z
    A Z
    C Z
    C Z
    A Z
    A Z
    C Z
    A Z
    C Z
    A Z
    C Z
    C Z
    A Z
    C Z
    B Y
    A Z
    B X
    C Y
    C Y
    C Z
    A Z
    A X
    C Z
    C Z
    C Z
    B Z
    C Z
    C Z
    C Z
    A Z
    C Z
    C Z
    A X
    C Z
    C Y
    A X
    A Z
    C Z
    C Z
    A Z
    C X
    A Z
    C Z
    C Y
    A Z
    A Y
    A Z
    C Z
    C Z
    C Z
    C Z
    C X
    C Z
    C Z
    B X
    B X
    A Z
    C Z
    C Z
    A Z
    A Z
    A Z
    C Y
    C Z
    C Z
    C Y
    C Y
    C Z
    C Z
    B X
    A Z
    C Z
    C Y
    A Z
    C Z
    A Z
    C Z
    C Y
    C Y
    C Z
    B X
    A Z
    B X
    C Z
    C Z
    C Z
    A Z
    C Z
    C Y
    C Z
    B Y
    C Z
    C Z
    C Y
    A Z
    C Z
    B X
    C Z
    B Y
    C Y
    C Z
    C Z
    C Z
    B Y
    A Z
    C Z
    A Y
    A Z
    C Y
    A Z
    C Z
    C Z
    C Y
    B Z
    B X
    C Z
    B Z
    C Z
    C Y
    B X
    C Y
    C Z
    A X
    A Z
    C Y
    C Y
    A Z
    C Y
    B Z
    B Y
    C X
    B X
    C X
    C Z
    C Y
    C Z
    C Z
    C Y
    C Z
    A Z
    C Y
    A X
    C Z
    C Z
    C Z
    C Z
    C Z
    C Z
    A Z
    B Y
    C Z
    C Z
    A Z
    B X
    C Z
    C Z
    A Z
    C Z
    C Z
    A Z
    C Z
    A X
    B Y
    C Y
    C Y
    C X
    A Z
    C X
    C Z
    B Z
    B X
    C Y
    A Z
    C Z
    C Z
    A X
    A Z
    C Y
    A X
    C Z
    C Z
    C Z
    A Z
    A Z
    C Z
    B Y
    B X
    B X
    A Z
    C Z
    C Y
    C Z
    C Z
    A Z
    A X
    C Y
    A Z
    C Y
    C Y
    A X
    A Z
    B X
    A Z
    B Y
    A Z
    C Z
    B X
    A Z
    B X
    C Y
    B Z
    C Y
    C X
    C Z
    C Y
    B X
    B Y
    B Y
    C Z
    C Y
    A Z
    A Z
    C Y
    C Z
    C Y
    B Z
    C Z
    C X
    C Z
    C Z
    B X
    C Z
    B X
    A Z
    C Z
    C Y
    A Z
    C Z
    C Y
    C X
    A X
    A Y
    C Y
    C Y
    C Y
    A Z
    B Z
    A Z
    C Z
    C Z
    C Z
    A Z
    A X
    A Z
    C X
    B X
    C Z
    A X
    A Z
    C Y
    A Z
    A Z
    A Z
    C Z
    C Z
    A Z
    C Z
    A Z
    A Z
    C Z
    C Y
    A Z
    C Y
    A Z
    A Z
    A Z
    B X
    B X
    A Z
    C Z
    C Y
    A Z
    C Z
    B X
    C Z
    C Z
    C Z
    A Z
    A X
    C Z
    C Z
    A X
    A Z
    C Y
    C Z
    C Z
    C Z
    C Z
    C Z
    C Y
    C Z
    A Z
    C Z
    B X
    B X
    A Z
    C Z
    C Y
    C Y
    B X
    B X
    C Y
    C X
    B X
    A Z
    A Z
    C Z
    C Y
    A Z
    C Z
    C Z
    C Z
    A Z
    C Z
    C Z
    B X
    C Y
    C Z
    C Z
    C Z
    C Z
    C Z
    C Y
    A X
    C Z
    C Z
    A Z
    A Z
    C Y
    C Z
    C Z
    C Z
    A Z
    B X
    C Z
    A X
    A Z
    A Z
    C Z
    A Z
    C Z
    C Z
    C Z
    C X
    C Z
    B X
    C X
    C Y
    C Z
    A X
    A X
    A Y
    C X
    C Y
    B X
    C X
    A Z
    C Z
    C X
    C Z
    C Y
    A X
    A Z
    C Z
    C Z
    A X
    A Y
    B X
    C Z
    C Z
    C Z
    B X
    C Z
    A Z
    A Y
    A Z
    C Z
    B X
    A Z
    C Z
    C Z
    C Z
    B X
    C Z
    C X
    C Z
    C Z
    B X
    C Y
    A X
    C Z
    C Y
    C Z
    C Y
    A Z
    C Z
    A Z
    A Z
    C Z
    C Z
    A Z
    C Y
    C Y
    B Y
    A Z
    A Z
    B X
    C Z
    C Z
    A X
    B Z
    C Z
    C Z
    A Z
    A X
    C Z
    C Z
    C X
    C Z
    B X
    A Z
    C Y
    A Z
    C Z
    C Z
    A X
    C Z
    C Z
    A Z
    C Z
    A Z
    B X
    C Y
    A Z
    C Y
    A Z
    A Y
    B X
    C Z
    A Y
    C Z
    C Z
    B X
    C Z
    A X
    C Z
    A Z
    A X
    C Y
    B X
    C Z
    C Z
    C Y
    A X
    B X
    A X
    A Z
    C Z
    B Y
    C Z
    A Z
    C Z
    A X
    B Z
    C Z
    C Y
    C Y
    A Y
    B X
    C Y
    C Z
    A Y
    C Y
    C Y
    A Z
    A Z
    C Z
    C Z
    C Z
    C Y
    A Z
    C Z
    C Z
    A Z
    B Y
    C Z
    C Y
    C Z
    C Z
    B Y
    A X
    C Z
    A X
    C Z
    C X
    A Z
    C Z
    A Z
    C Z
    B X
    C Z
    C Z
    C X
    C Z
    C Z
    A Z
    A Z
    B Z
    C X
    C Y
    C Y
    C Y
    A Z
    C X
    C Z
    A X
    C Z
    C Z
    C X
    A X
    A X
    C Z
    A X
    B Z
    C Y
    C Z
    C Y
    C Z
    C Y
    C Z
    A Z
    A X
    C Z
    B Y
    C Z
    C Z
    B X
    C Z
    B X
    C Z
    C Y
    A X
    A Z
    C X
    C Y
    C Z
    C X
    C Z
    B X
    A Z
    C X
    A Y
    B Z
    C Z
    B X
    C Z
    C Z
    C Y
    C Z
    A X
    B X
    C Z
    A Z
    C Z
    C Z
    C Z
    A X
    C Z
    A Y
    C Z
    C Z
    C Z
    C Y
    A Z
    C X
    A X
    C Y
    C Z
    A Z
    A Y
    C Z
    B Y
    C X
    A Z
    C Y
    C Z
    A X
    C Z
    A Z
    B X
    A Z
    C Z
    B Z
    A Z
    A Z
    C Y
    C Z
    A Y
    A Z
    C Y
    C Z
    C Z
    C Z
    C Y
    C X
    B X
    C Z
    B Y
    C X
    A Z
    C Z
    C Z
    A Z
    C Z
    B Y
    A Z
    B Y
    A Z
    C Y
    C Z
    C Z
    A Z
    C Z
    B Y
    C X
    A Z
    A X
    C Z
    C Z
    C X
    A X
    C Z
    C Y
    C Z
    C Z
    C Z
    B Y
    C Z
    A Z
    A Z
    B X
    A Z
    C Z
    C Z
    C Z
    A X
    C Y
    C Z
    C Z
    C Z
    B X
    A Z
    A X
    B Y
    B X
    B X
    C Z
    B X
    C Y
    A X
    C X
    C Z
    C Z
    C Y
    C Z
    C Z
    A X
    A Z
    A X
    B Y
    A X
    A Z
    B Y
    C X
    C Y
    C Z
    C Z
    A Z
    A X
    B Y
    A Z
    C Z
    C Z
    C Y
    A Z
    A X
    C Z
    A Y
    A Z
    A X
    B X
    B Y
    C Z
    C Z
    A Z
    C Z
    A X
    A Z
    C Z
    C Y
    B X
    A Z
    B X
    C Y
    B X
    A Z
    A Z
    A Z
    B Y
    C Z
    A Z
    C Z
    C X
    B Y
    C Z
    A Z
    C Z
    A Z
    A X
    C Z
    C Z
    C X
    C Y
    B X
    B Y
    A Z
    A Y
    A Z
    C Z
    A X
    A X
    A Z
    B X
    C Z
    B X
    B X
    C Y
    A Z
    A X
    C Z
    B X
    B Y
    A X
    B X
    A Y
    C Z
    A Z
    C Z
    C Y
    C Y
    C Z
    C Y
    B X
    C Z
    B Y
    A Z
    A X
    B X
    C X
    C Z
    A Z
    C Z
    C Z
    B X
    B Y
    C Y
    A Z
    C X
    C Z
    A Z
    C Z
    C Z
    C Y
    A Z
    A Z
    C X
    C X
    C Y
    C Z
    A X
    A Z
    C Y
    C Y
    C Z
    A Z
    B Y
    C Y
    A Z
    C Y
    A Z
    B Z
    B Y
    A Y
    B X
    C Y
    C Z
    A Z
    C Z
    B Z
    C Z
    C Z
    A Z
    B Y
    C Z
    B X
    C Z
    C Z
    C Y
    C Y
    A Z
    A Y
    C Z
    C X
    C Z
    A Z
    A Z
    C Z
    C X
    C Y
    A Y
    C Y
    A X
    C Z
    A Z
    C Z
    B X
    C Z
    C Z
    C Z
    A Z
    A Y
    B Y
    A Z
    A Z
    B X
    A X
    C Z
    C Z
    B X
    C Y
    A X
    C Y
    A X
    B X
    C Z
    C Z
    C X
    A Z
    C Z
    C Z
    C Z
    C Z
    A Z
    A Y
    A Z
    B Z
    C Z
    B X
    C Z
    B X
    A Z
    C Z
    C Z
    B Z
    C Y
    B Y
    C Z
    A Z
    A Z
    C Y
    C Y
    C Z
    C Y
    C Z
    A X
    C Y
    B X
    C Y
    C Y
    B Y
    C Z
    C Z
    B X
    C Z
    B X
    B Y
    B X
    B X
    C Y
    A Z
    C Y
    C Y
    C Z
    C Z
    B X
    C Z
    A Z
    C Y
    B X
    B X
    C Y
    C X
    C Z
    C Z
    A X
    C Z
    B X
    C Z
    C Z
    A X
    A Z
    C X
    A Z
    A Z
    C Y
    C Z
    C X
    C Y
    C Z
    A Z
    C Z
    B X
    C Z
    C Z
    A X
    C Z
    A X
    C Z
    C X
    C Y
    A X
    A Z
    C X
    C Z
    A X
    A Z
    C Z
    C Y
    B X
    A X
    B X
    C Z
    A Z
    C X
    C Z
    B X
    A Z
    C Z
    C Z
    B Z
    B X
    B Y
    C Y
    C Z
    B X
    C Z
    B Y
    C Y
    A Z
    C Z
    C Y
    A Z
    C Z
    A Z
    C Y
    C Y
    A X
    B Z
    C Y
    B X
    C Z
    C Y
    C Z
    C X
    B X
    B Y
    A Z
    C Z
    C Z
    A Z
    B Z
    C Z
    C Y
    C X
    A Z
    C Z
    B X
    C Z
    A X
    C Z
    C Z
    A Z
    A X
    C Y
    B Z
    C Y
    C Z
    C Z
    C Z
    A Z
    A Z
    C Z
    A X
    C Z
    A Z
    C Z
    C Z
    C Z
    B Y
    C Z
    C Z
    B Y
    A X
    B X
    C Z
    C Z
    C Y
    A X
    C Z
    A Z
    C Y
    A Z
    A Z
    C Y
    B X
    A Z
    C Y
    C Z
    C X
    B X
    A Z
    C Z
    C Y
    C Z
    B Z
    B X
    A Z
    A Z
    C Y
    A Z
    C Z
    B X
    A Z
    C Z
    C Z
    C X
    C Z
    C Y
    B X
    A Z
    C Z
    C Z
    C Z
    B X
    A Z
    B Y
    C Z
    C Z
    A Z
    B X
    B X
    B X
    C Z
    C Z
    A Z
    C Z
    C Z
    B Y
    B X
    A Z
    C Z
    C Z
    C Z
    A Z
    B X
    C Z
    C Z
    C Y
    C Z
    C Y
    A Z
    C Z
    A X
    C Z
    C Z
    B Y
    C Z
    C Y
    B X
    A Z
    C Z
    C Z
    C Z
    A Z
    C Y
    A X
    C Z
    C Z
    A Z
    C Z
    A X
    B X
    A Z
    C Z
    B Z
    C Z
    A Y
    B X
    A X
    C Z
    C Z
    C Z
    C Y
    B X
    C X
    A Z
    C Z
    C Z
    C Y
    A Z
    C Z
    C Z
    B Y
    C Y
    B X
    C Z
    A X
    A Z
    C Z
    C Z
    C X
    C Z
    B X
    C Z
    C Z
    C Z
    C Y
    C Z
    C Z
    C Z
    C Z
    A Z
    C Z
    A Z
    A Z
    B X
    A Z
    C X
    B X
    B X
    A Z
    C Z
    C Y
    C Z
    C Z
    C X
    C Z
    A X
    A Z
    C Z
    C Z
    C Z
    C Z
    C Z
    C Z
    B Z
    C Z
    A Z
    C Z
    A Z
    A X
    B X
    A Z
    C Z
    C Y
    C Z
    C Y
    A Z
    A Z
    A Z
    A Z
    A Z
    B Z
    A Z
    C X
    C Z
    C Z
    C Z
    B Y
    C Z
    B X
    A Z
    B Y
    C Y
    C Y
    C Z
    B X
    B X
    A Z
    A Z
    A Z
    A Z
    C Z
    C X
    A Z
    C Y
    B X
    C Z
    C Z
    C Z
    C Z
    A X
    C Z
    A Z
    C Y
    A Z
    C Z
    C Z
    B X
    C Z
    B Z
    C Y
    C Z
    C Z
    C Z
    C Z
    C Z
    A Z
    C Z
    A Z
    A Z
    A Z
    C Z
    C Z
    A Z
    C Y
    C Z
    B Z
    C Z
    C Z
    C Y
    C Z
    A Y
    C Z
    A X
    A Z
    C X
    C Z
    A Z
    A Z
    A Z
    A Z
    C Z
    A Z
    A Z
    C Z
    C Z
    C Z
    C Z
    A Z
    C Y
    C Z
    C Z
    A Z
    C Z
    B X
    B Y
    C Z
    C Z
    A Z
    C Z
    A Z
    C Y
    C Z
    A Z
    C Z
    C X
    A Z
    C Z
    C X
    C Z
    C Y
    A Z
    C Z
    C Z
    C Z
    B Z
    C X
    C Z
    C Z
    A X
    A Z
    A Z
    A Z
    C Z
    C Z
    C X
    A Z
    A Z
    C Y
    C Z
    A Z
    A Z
    A Z
    C Y
    A Z
    C Z
    A Z
    C Z
    C Z
    A Z
    C Y
    B X
    B X
    A Z
    B Z
    A Z
    C Z
    C Z
    C X
    A Z
    C Y
    C Z
    C Y
    C Z
    C Z
    A Z
    C Y
    C Z
    C Y
    C Z
    C Z
    C Z
    C Z
    C Y
    A X
    A X
    C Z
    C Z
    B X
    C X
    C X
    C Z
    A X
    C Y
    A X
    B X
    C X
    C Z
    C Z
    A X
    C Y
    A Y
    A Z
    C Z
    C Y
    C Y
    B X
    A X
    C Z
    C Z
    B X
    A Z
    C Z
    B Z
    C Z
    C Y
    C X
    C Z
    A Z
    C Z
    B X
    B X
    C Y
    C Y
    C Z
    C Y
    A Z
    B X
    C Z
    C Y
    A Z
    C Z
    B Z
    B X
    A Z
    A Z
    B Y
    B Y
    A Z
    C Z
    B X
    A Z
    C Z
    A Z
    C Z
    B X
    A Z
    B X
    B X
    A X
    C Z
    A X
    A X
    A Z
    C Y
    C X
    A X
    C Z
    C Y
    C Z
    A Z
    A Z
    A X
    C Z
    A Z
    C Z
    C Y
    A Z
    C Z
    B X
    A Z
    B Y
    C Z
    C Y
    C Z
    C Z
    A Z
    A Z
    C X
    A X
    C Y
    C Z
    C Y
    C Z
    C Z
    C Z
    A Z
    A Y
    A X
    A Z
    C X
    B Z
    C Z
    A Z
    A Z
    A Z
    B X
    A Z
    C Z
    C Z
    B X
    C Z
    A X
    A Y
    C Z
    A Z
    C Z
    C Z
    B X
    C Z
    C Z
    C Z
    C Z
    C Y
    C Z
    A Z
    C Z
    C Y
    C Z
    C Z
    C Z
    B X
    A Z
    C Z
    C Z
    C Z
    A X
    C Y
    C Z
    A Z
    C Y
    A Z
    C Y
    C Z
    C Z
    A Z
    A Z
    C Y
    A Z
    B Z
    C Z
    C Z
    B Z
    A X
    B X
    C Z
    C Y
    A Z
    C Y
    B Y
    A X
    C Z
    C Z
    C Z
    C Z
    A Z
    C Z
    A X
    C Y
    A Z
    C Z
    B X
    B Y
    C Z
    C Y
    C Z
    B X
    C Y
    C Y
    C Z
    B X
    C X
    A Y
    C Z
    C Y
    A Z
    C Y
    A X
    B Y
    A Y
    C Z
    C Z
    A Z
    C Z
    C X
    A Z
    C Z
    C Z
    C Z
    C Y
    C Z
    A Z
    B X
    A Z
    C Z
    B X
    C Z
    A Z
    C Z
    B Y
    A Z
    C Z
    A Z
    C Z
    A X
    C Y
    A Z
    C Z
    C Z
    C Y
    A Z
    B X
    C Z
    A Z
    C Z
    C Z
    A Z
    C Z
    C X
    A Z
    C Z
    C Z
    C Z
    C Z
    B Z
    C Z
    C Z
    C Z
    C Y
    B X
    A X
    C Z
    C Z
    C Z
    C Z
    C Z
    C Z
    C Z
    B Z
    C Z
    A X
    C Z
    B Y
    A Z
    A X
    C Z
    C Z
    A Z
    C Z
    C Y
    A X
    C Y
    C Z
    C Z
    C Z
    C X
    C Y
    C Z
    C Y
    C Z
    A Y
    C Z
    A X
    C X
    C Z
    C Z
    C Z
    A Z
    C Z
    B X
    C Y
    A Z
    C Z
    C X
    C Z
    C Z
    C Z
    A Y
    A X
    A Z
    C Y
    B X
    B X
    A Z
    A Z
    A Z
    C Z
    C Z
    A Z
    C Z
    A Y
    C Y
    C Z
    C Y
    B Z
    B Y
    B X
    A X
    C Z
    C Z
    C Z
    C Y
    B X
    A X
    C X
    A Z
    A Z
    C Z
    C Y
    A Z
    A Z
    A Z
    C Z
    C Z
    C Y
    B X
    A Z
    C Z
    A X
    C Y
    A Y
    B Y
    A Z
    A Z
    A Z
    C Z
    C Z
    B X
    A Y
    C Z
    A Y
    C Y
    C Z
    A Z
    C Y
    B X
    C Z
    C Z
    C Z
    B X
    B X
    C X
    B X
    A Z
    A Z
    C Z
    C Z
    A X
    C Z
    C Z
    C Z
    A Z
    A Z
    A Z
    B X
    C X
    C Z
    A Z
    A Z
    B X
    B X
    C X
    B X
    A Z
    C Z
    C Z
    A X
    C X
    A Z
    C Y
    A Z
    A Z
    B X
    C Z
    C Z
    A Z
    A Z
    C Z
    C Z
    C Y
    C Y
    C Z
    C Y
    C Z
    C Z
    C Y
    A X
    C Z
    C Z
    A Z
    C Z
    A Z
    C Z
    C Z
    C Y
    C Z
    C Y
    A Z
    C Z
    C Y
    B Z
    B X
    B X
    A X
    C Z
    C Z
    A Y
    C Z
    C X
    C Z
    A Z
    A Z
    A Z
    C Y
    B Y
    B X
    A Z
    C Z
    C Z
    C Y
    A Z
    C Z
    C Z
    A X
    A X
    B X
    A Z
    C Z
    A X
    C Z
    A Z
    C Z
    C Z
    A Z
    C Z
    B Y
    B X
    A Z
    C Y
    C Z
    C Z
    A X
    C Z
    C X
    A Z
    B X
    C Z
    C Z
    C Z
    C Z
    C X
    C Z
    A Z
    C Z
    A Y
    B X
    A Z
    A X
    A Z
    C Y
    C Z
    C Y
    C Y
    C Y
    C X
    C Y
    C Z
    C Z
    C Z
    C Y
    B X
    C Z
    B X
    C Z
    C Z
    A Z
    B X
    C Z
    A X
    C Y
    B Y
    A X
    B Z
    B X
    A X
    A X
    A X
    B Y
    C Y
    C Z
    B X
    C Y
    C X
    A Z
    C Y
    A Z
    C Z
    C X
    B X
    C Y
    A Z
    C Y
    C Z
    A Z
    C Y
    B Y
    C Y
    B X
    A Z
    C Y
    C Y
    C Z
    C Z
    C X
    B X
    C Z
    B X
    C Z
    C Z
    A Z
    C Z
    A Z
    C Z
    C Z
    C Y
    C Y
    C Z
    C Y
    A Z
    C Z
    C Y
    A Z
    C Z
    C Z
    C Y
    C Z
    B X
    B X
    A X
    C Z
    A Z
    C Z
    A Z
    C Z
    B Y
    A X
    C Y
    C Y
    B X
    A Z
    C Z
    C Z
    C Y
    C Z
    A Z
    C Y
    B Z
    C Y
    C Z
    C Z
    C X
    C Y
    B X
    C Y
    C Z
    C X
    A Z
    C Z
    C Z
    C Y
    A Z
    C Z
    A Z
    C Y
    A Z
    A Z
    A Y
    C Z
    A Z
    C Z
    A Z
    C Z
    C Z
    B Z
    A X
    C Y
    A X
    C Z
    C Z
    A Z
    C Z
    A X
    A X
    C Z
    B X
    B Z
    C Y
    C Z
    A X
    B X
    C Z
    C Z
    B X
    A Z
    C Z
    A Z
    A Y
    C Z
    A Z
    C Y
    C Y
    A Y
    B X
    C Z
    C Y
    A X
    C Z
    C Y
    A X
    A Z
    C Y
    B X
    C Z
    A Z
    C Z
    C Z
    A Z
    C Z
    C Y
    C Y
    C Z
    A Z
    B Z
    C Y
    A Z
    C Z
    C Y
    C X
    C Z
    C Z
    A Z
    C Z
    C X
    C Z
    C X
    C Y
    C Z
    A Z
    C Z
    A Z
    B X
    C Z
    B X
    C Z
    A X
    C Z
    C Z
    B Y
    C Z
    C Z
    B X
    C Z
    C Y
    C Y
    B X
    A Z
    A X
    A Z
    A X
    C Y
    B X
    A Z
    C Y
    A Z
    C Z
    B X
    B Z
    C Z
    C Y
    C Y
    C Y
    A Z
    B X
    C Z
    C X
    A X
    B Z
    C Y
    B X
    A Z
    C Z
    C Z
    C Z
    C Z
    C Y
    B X
    C Z
    C Z
    C Z
    C Z
    A X
    A Z
    C Z
    C Y
    C Y
    C Z
    A Y
    C Z
    C Z
    C Z
    B X
    C Y
    C Z
    C Z
    A Z
    C Z
    C Z
    C Z
    B X
    A Z
    B X
    C Z
    C X
    A X
    C Z
    C Z
    C Z
    C X
    A Z
    A Z
    B X
    A Z
    C Z
    C Z
    A Z
""".trimIndent()

enum class OpponentMove {
    A, // Rock
    B, // Paper
    C  // Scissors
}

enum class OwnMove(val beats: OpponentMove, val losesAgainst: OpponentMove, val score: Int) {
    X(OpponentMove.C, OpponentMove.B, 1),
    Y(OpponentMove.A, OpponentMove.C, 2),
    Z(OpponentMove.B, OpponentMove.A, 3);

    fun playRound(opponentMove: OpponentMove): Int {
        return when {
            this.beats == opponentMove -> score + 6
            this.losesAgainst == opponentMove -> score
            else -> score + 3
        }
    }

    companion object {

        fun whatLosesAgainst(opponentMove: OpponentMove): OwnMove {
            return OwnMove.values().first { it.losesAgainst == opponentMove }
        }

        fun whatBeats(opponentMove: OpponentMove): OwnMove {
            return OwnMove.values().first { it.beats == opponentMove }
        }

        fun whatDraws(opponentMove: OpponentMove): OwnMove {
            return OwnMove.values().first { it.beats != opponentMove && it.losesAgainst != opponentMove }
        }
    }

}

fun roundPoints(round: List<String>): Int {
    val opponentMove = OpponentMove.valueOf(round[0])
    val ownMove = OwnMove.valueOf(round[1])
    return ownMove.playRound(opponentMove)
}

fun fulfillExpectation(round: List<String>): Int {
    val opponentMove = OpponentMove.valueOf(round[0])
    val expectedMove = when(round[1]) {
        "X" -> OwnMove.whatLosesAgainst(opponentMove)
        "Y" -> OwnMove.whatDraws(opponentMove)
        else -> OwnMove.whatBeats(opponentMove)
    }
    return expectedMove.playRound(opponentMove)
}

fun main() {
    val gameRounds = strategyGuide.lines().map { line -> line.split(" ") }
    println ("Game rounds: $gameRounds")
    val pointsPerRound = gameRounds.map { round -> roundPoints(round) }
    println("Round results $pointsPerRound")
    println("Total score ${pointsPerRound.sum()}")
    val pointsPerRoundByExpecation = gameRounds.map { round -> fulfillExpectation(round) }
    println("Round results by fulfilling expecations, $pointsPerRoundByExpecation")
    println("Total by expectation ${pointsPerRoundByExpecation.sum()}")
}