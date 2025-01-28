package problems.leetcode.das.trees

import problems.Problem

/**
 * Minimum Depth of Binary Tree
 * URL: https://leetcode.com/problems/minimum-depth-of-binary-tree/editorial/
 *
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Note: A leaf is a node with no children.
 */
class MinimumDepthOfBinaryTree : Problem {
    override fun execute() {
        example1()
        example2()
    }

    fun minDepth(root: TreeNode?): Int {
        return calculateMinDepth(root, 0)
    }

    private fun calculateMinDepth(node: TreeNode?, accumulatedDepth: Int): Int {
        if (node == null) {
            return accumulatedDepth
        }

        val newAccum = accumulatedDepth + 1

        // Left Path
        val left = calculateMinDepth(node.left, newAccum)

        // Right Path
        val right = calculateMinDepth(node.right, newAccum)

        return if (node.left != null && node.right == null)
            left
        else if (node.left == null && node.right != null)
            right
        else
            Math.min(left, right)
    }

    private fun example1() {
        // Input: root = [3,9,20,null,null,15,7]
        // Output: 2
        val rootNode = TreeNode(3)
        val node9 = TreeNode(9)
        val node20 = TreeNode(20)
        rootNode.left = node9
        rootNode.right = node20

        val node15 = TreeNode(15)
        val node7 = TreeNode(7)
        node20.left = node15
        node20.right = node7

        DepthFirstSearchExample().preOrderTraverse(rootNode)

        val min = minDepth(rootNode)
        println("Min: $min")
    }

    private fun example2() {
        // Input: root = [2,null,3,null,4,null,5,null,6]
        // Output: 5
        val rootNode = TreeNode(2)
        val node3 = TreeNode(3)
        rootNode.right = node3

        val node4 = TreeNode(4)
        node3.right = node4

        val node5 = TreeNode(5)
        node4.right = node5

        val node6 = TreeNode(6)
        node5.right = node6

        DepthFirstSearchExample().preOrderTraverse(rootNode)

        val min = minDepth(rootNode)
        println("Min: $min")
    }
}