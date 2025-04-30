package utils

import problems.leetcode.das.trees.TreeNode
import kotlin.math.pow

/**
 * Build tree from array list
 *
 * @entries Array with the list of numbers to create
 * @return root node
 */
fun buildTreeFromArrayList(entries: ArrayList<Int?>): TreeNode? {
    var root: TreeNode?  = null;

    // Queue to host the nodes so it
    val nodes = ArrayDeque<TreeNode?>()

    // Create the nodes
    for (i in 0 until entries.size) {

        // Get current element
        val value: Int? = entries[i]

        println("Entries[$i] - Value: $value")

        // Create a TreeNode with the collected value
        val currentNode = if (value != null) {
            TreeNode(value)
        } else {
            null
        }

        // Add node to the parent's queue
        if (currentNode != null) {
            nodes.add(currentNode)
        }

        // Move to the next item if this is the first one.
        if (i == 0) {
            root = currentNode
            continue
        }

        // Determine if the index represents and item from the left or from the right
        val isLeft = i.mod(2) > 0
        println("----> Value: $value - Is Item Left: $isLeft")
        if (isLeft) {
            val headNode = nodes.firstOrNull()
            println("----> Parent Node: ${headNode?.`val`}")
            headNode?.left = currentNode
        } else {
            val headNode = nodes.removeFirstOrNull()
            println("----> Parent Node: ${headNode?.`val`}")
            headNode?.right = currentNode
        }

    }

    return root
}

/*
fun buildTreeFromArrayList(entries: ArrayList<Int?>): TreeNode? {
    var root = null

    // Variables require to traverse the tree
    var level = 0

    // Pointer to the parent
    var offset = 0 //

    // Max Level
    var maxLevel = log2(entries.size.toDouble()).toInt()

    // Containers for preprocessed nodes
    val nodes = ArrayList<TreeNode?>()

    for (i in 0 until entries.size) {

        // Get current element
        val value: Int? = entries[i]

        // Create the element
        var currentNode = if (value != null) {
            TreeNode(value)
        } else {
            null
        }

        // Get parent node
        val results: Pair<Int, Boolean> = getParentInfo()
        val parentNode = nodes.getOrNull(results.first)

        // Determine whether it is right of left

        // Update variables
        val levelInitialOffset: Int = 2.toDouble().pow(level).toInt()
        val levelOffset = i - levelInitialOffset

        // Update level from index
        level = getNextLevel(level, i)


    }

    entries.size

    // Iterate until there are no more elements

    return null
}
 */

fun getNextLevel(currentLevel: Int, currentPosition: Int): Int {
    val maxPositionPerLevel = 2.toDouble().pow(currentLevel).toInt()
    return if (currentPosition == maxPositionPerLevel) {
        currentLevel + 1;
    } else {
        currentLevel
    }
}

/**
 * Calculate the index inside an array based on the passed information
 *
 * @param level The offset represented by 2 ^ level
 * @param currentIndex The position within the array. This value is always greater or equal than level
 */
fun getParentNodeIndex(level: Int, currentIndex: Int) {

}