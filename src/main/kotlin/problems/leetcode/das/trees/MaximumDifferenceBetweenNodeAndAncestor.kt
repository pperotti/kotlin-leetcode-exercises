package problems.leetcode.das.trees

import kotlin.math.max

/**
 * Leetcode Problem: Maximum Difference between node and ancestor
 * URL:https://leetcode.com/explore/item/4617
 *
 * Given the root of a binary tree, find the maximum value v
 * for which there exist different nodes a and b where
 * v = |a.val - b.val| and a is an ancestor of b.
 *
 * A node a is an ancestor of b if either: any child of a
 * is equal to b or any child of a is an ancestor of b.
 */
class MaximumDifferenceBetweenNodeAndAncestor {

    fun maxAncestorDiff(root: TreeNode?): Int {
        return findMaxDiff(node = root, 0, -1)
    }

    private fun findMaxDiff(node: TreeNode?, max: Int, min: Int): Int {
        if (node == null) {
            // Here is where we process the info in the container.
            println("node == null -> max: $max min: $min")
            return max - min
        }

        println("node: ${node.`val`} -> max: $max min: $min")

        val newMax = max(max, node.`val`)
        val newMin = if (min != -1 && min < node.`val`) {
            min
        } else {
            node.`val`
        }

        val left = findMaxDiff(node.left, newMax, newMin)
        val right = findMaxDiff(node.right, newMax, newMin)

        println("-----> after: ${node.`val`} -> left: $left right: $right")

        return max(left, right)
    }

    /* // Solution #1 - Works but it's inefficient
    fun maxAncestorDiff(root: TreeNode?): Int {
        return findMaxDiff(node = root, intArrayOf())
    }

    private fun findMaxDiff(node: TreeNode?, container: IntArray): Int {
        if (node == null) {
            // Here is where we process the info in the container.
            val max = container.max()
            val min = container.min()

            println("node == null -> max: $max min: $min container: ${container.joinToString(",")}")

            return max - min
        }

        println("node: ${node.value} -> ${container.joinToString(",")}")

        val newContainer = container + node.value

        val left = findMaxDiff(node.left, newContainer)
        val right = findMaxDiff(node.right, newContainer)

        println("-----> after: ${node.value} -> left: $left right: $right")

        return max(left, right)
    }
    */
}
