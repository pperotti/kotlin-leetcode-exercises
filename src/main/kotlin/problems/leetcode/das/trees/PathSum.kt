package problems.leetcode.das.trees

/**
 * Leetcode Problem: 112. Path Sum
 * URL: https://leetcode.com/problems/path-sum
 *
 * Given the root of a binary tree and an integer targetSum,
 * return true if the tree has a root-to-leaf path such that
 * adding up all the values along the path equals targetSum.
 *
 * A leaf is a node with no children.
 */
class PathSum {

    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
        return findTargetSum(root, targetSum, 0)
    }

    private fun findTargetSum(node: TreeNode?, targetSum: Int, accumValue: Int): Boolean {
        if (node == null) {
            return false
        }

        val newAccumValue = accumValue + node.value

        return if (newAccumValue == targetSum
            && node.left == null
            && node.right == null
        ) {
            true
        } else {
            val isInLeft = findTargetSum(node.left, targetSum, newAccumValue)
            val isInRight = findTargetSum(node.right, targetSum, newAccumValue)
            isInLeft || isInRight
        }
    }
}
