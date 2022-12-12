package org.aoc22.day7

class FSNode(
    val name: String,
    val isDirectory: Boolean,
    val size: Int,
    val parent: FSNode?
) {
    var children = mutableListOf<FSNode>()
    override fun toString(): String {
        return "FSNode(name='$name', isDirectory=$isDirectory, size=$size, parent=$parent, children=${children.size})"
    }

    fun getTotalSize(): Int {
        return if (this.isDirectory) {
            children.sumOf { it.getTotalSize() }
        } else {
            this.size
        }
    }

    fun getAllSubDirs(): List<FSNode> {
        return if (this.isDirectory) {
            return listOf(this) + children.flatMap { it.getAllSubDirs() }
        } else {
            emptyList<FSNode>()
        }
    }


    fun print(indent: String) {
        if (this.isDirectory) {
            println("$indent - $name (dir, childrensize=${this.getTotalSize()})")
            children.forEach { it.print("  $indent") }
        } else {
            println("$indent - $name (file, size=$size)")
        }
    }
}

enum class CommandType {
    LS,
    CD
}

data class Command(val commandType: CommandType, val arguments: String) {
    var output = mutableListOf<String>()

    fun changeDir(currentNode: FSNode): FSNode {
        return if (arguments == "/") {
            var rootNode = currentNode
            while (currentNode.parent != null) {
                rootNode = currentNode.parent
            }
            rootNode
        } else if (arguments == "..") {
            currentNode.parent!!
        } else {
            currentNode.children.first { it.name == arguments }
        }
    }

    fun buildFromListing(currentNode: FSNode): FSNode {
        output.forEach { outputLine ->
            if (outputLine.startsWith("dir")) {
                currentNode.children.add(
                    FSNode(
                        name = outputLine.substringAfter("dir").trim(),
                        size = 0,
                        isDirectory = true,
                        parent = currentNode
                    )
                )
            } else {
                val fileRegex = "(\\d*) (.*)".toRegex()
                val (size, name) = fileRegex.find(outputLine)!!.destructured
                currentNode.children.add(
                    FSNode(
                        name = name,
                        size = size.toInt(),
                        isDirectory = false,
                        parent = currentNode
                    )
                )
            }
        }
        return currentNode
    }

    fun apply(currentNode: FSNode): FSNode {
        return when (commandType) {
            CommandType.CD -> changeDir(currentNode)
            CommandType.LS -> buildFromListing(currentNode)
        }
    }
}

fun parseListing(): FSNode {
    val rootNode = FSNode("/", true, 0, null)
    var currentNode = rootNode

    val commandList = shellOutput.fold(listOf<Command>()) { commands, line ->
        if (line.startsWith("$ cd")) {
            commands + Command(CommandType.CD, line.substringAfter("cd").trim())
        } else if (line.startsWith("$ ls")) {
            commands + Command(CommandType.LS, "")
        } else {
            commands.last().output.add(line)
            commands
        }
    }

    println(commandList)
    val commandIterator = commandList.iterator()
    while (commandIterator.hasNext()) {
        val command = commandIterator.next()
        println("$command, ${currentNode.name}")
        currentNode = command.apply(currentNode)
    }

    return rootNode
}

fun main() {
    val root = parseListing()
    root.print("")
    val allDirectories = root.getAllSubDirs() + root
    println(allDirectories)
    val directoriesUnderLimit = allDirectories.map { it.getTotalSize() }.filter { it <= 100000 }.sum()
    println(directoriesUnderLimit)

    val missingSpace = 30000000 - (70000000 - root.getTotalSize())
    println(missingSpace)
    val toDelete = allDirectories.map { it.getTotalSize() }.filter { it >= missingSpace }.min()
    println(toDelete)
}