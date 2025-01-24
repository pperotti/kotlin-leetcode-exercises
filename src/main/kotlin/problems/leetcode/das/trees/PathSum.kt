package problems.leetcode.das.trees

import problems.Problem

/**
 * 112. Path Sum
 * URL: https://leetcode.com/problems/path-sum
 *
 * Given the root of a binary tree and an integer targetSum,
 * return true if the tree has a root-to-leaf path such that
 * adding up all the values along the path equals targetSum.
 *
 * A leaf is a node with no children.
 */
class PathSum : Problem {

    override fun execute() {
        example4()
    }

    private fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
        return findTargetSum(root, targetSum, 0)
    }

    private fun findTargetSum(node: TreeNode?, targetSum: Int, accumValue: Int): Boolean {
        if (node == null) {
            return false
        }

        val newAccumValue = accumValue + node.value

        return if (newAccumValue == targetSum
            && node.left == null
            && node.right == null) {
            true
        } else {
            val isInLeft = findTargetSum(node.left, targetSum, newAccumValue)
            val isInRight = findTargetSum(node.right, targetSum, newAccumValue)
            isInLeft || isInRight
        }
    }

    /**
     * Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
     * Output: true
     *
     * Explanation: The root-to-leaf path with the target sum is shown.
     */
    private fun example1() {
        val root = TreeNode(5)
        val node4 = TreeNode(4)
        val node8 = TreeNode(8)
        root.left = node4
        root.right = node8

        // NOde 4 & link to Node 11
        val node11 = TreeNode(11)
        node4.left = node11

        // Node 8 and link to Node 13 & Node 4_2
        val node13 = TreeNode(13)
        val node4_2 = TreeNode(4)
        node8.left = node13
        node8.right = node4_2

        // Node 11 link to left and right nodes
        val node7 = TreeNode(7)
        val node2 = TreeNode(2)
        node11.left = node7
        node11.right = node2

        val node1 = TreeNode(1)
        node4_2.right = node1

        //DepthFirstSearchExample().preOrderTraverse(root)

        val targetSum = 22
        val isValueFound = hasPathSum(root, targetSum)
        println("Value $targetSum found in path: $isValueFound")
    }

    /**
     * Input: root = [1,2,3], targetSum = 5
     * Output: false
     */
    private fun example2() {
        val root = TreeNode(1)
        root.left = TreeNode(2)
        root.right = TreeNode(3)

        val targetSum = 3
        val isValueFound = hasPathSum(root, targetSum)
        println("Value $targetSum found in path: $isValueFound")
    }

    private fun example3() {
        val root = TreeNode(1)
        root.left = TreeNode(2)

        val targetSum = 1
        val isValueFound = hasPathSum(root, targetSum)
        println("Value $targetSum found in path: $isValueFound")
    }

    private fun example4() {
        val root = TreeNode(-2)
        root.right = TreeNode(-3)

        val targetSum = -5
        val isValueFound = hasPathSum(root, targetSum)
        println("Value $targetSum found in path: $isValueFound")
    }


}