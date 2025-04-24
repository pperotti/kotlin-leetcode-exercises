package problems.leetcode.das.trees

import kotlin.math.max

/**
 * Leetcode Problem: Diameter of binary tree
 * URL: https://leetcode.com/problems/diameter-of-binary-tree/editorial/
 *
 * Given the root of a binary tree, return the length of the diameter of the tree.
 *
 * The diameter of a binary tree is the length of the longest path between any two nodes
 * in a tree. This path may or may not pass through the root.
 *
 * The length of a path between two nodes is represented by the number of edges between them.
 */
class DiameterOfBinaryTree {

    // Auxiliary class to contain the biggest found. This is used to avoid
    // using member fields. Each function can live independently outside of this class.
    class MaxLength(var value: Int = 0)

    fun diameterOfBinaryTree(root: TreeNode?): Int {
        // Need a container to hold the max distance identified while traversing
        val maxLength = MaxLength(0)
        val ret = determineMaximumLength(root, 0, maxLength)
        println("ret: $ret - max: ${maxLength.value}")
        return maxLength.value
    }

    private fun determineMaximumLength(node : TreeNode?, currentLevel: Int, maxLength: MaxLength): Int {
        if (node == null) {
            return currentLevel
        }

        val newLevel = currentLevel + 1
        val leftLength = determineMaximumLength(node.left, newLevel, maxLength)
        val rightLength = determineMaximumLength(node.right, newLevel, maxLength)

        // We calculate the relative distance from the current level to the max depth of each
        // branch.
        val relLeft = leftLength - newLevel
        val relRight = rightLength - newLevel

        if (relLeft + relRight > maxLength.value) {
            maxLength.value = relLeft + relRight
        }
        return max(leftLength, rightLength)
    }
}
