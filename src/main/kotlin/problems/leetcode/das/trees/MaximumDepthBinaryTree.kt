package problems.leetcode.das.trees

import problems.Problem
import kotlin.math.max

/**
 * Problem Name: 104. Maximum Depth of Binary Tree
 * URL: https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 *
 * Given the root of a binary tree, return its maximum depth.
 *
 * A binary tree's maximum depth is the number of nodes along the longest path
 * from the root node down to the farthest leaf node.
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 *
 * Input: root = [1,null,2]
 * Output: 2
 */
class MaximumDepthBinaryTree : Problem {

    override fun execute() {
        //example1()
        //example2()
        example3()
    }

    private fun maxDepth(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        val left = maxDepth(root.left)
        val right = maxDepth(root.right)
        return max(left, right) + 1
    }

    // Input: root = [3,9,20,null,null,15,7]
    private fun example1() {
        val root = TreeNode(3)
        root.left = TreeNode(9)
        root.right = TreeNode(20)
        root.right?.left = TreeNode(15)
        root.right?.right = TreeNode(7)

        println("Depth: ${maxDepth(root)}")
    }

    // Input: root = [1,null,2]
    private fun example2() {
        val root = TreeNode(1)
        root.right = TreeNode(2)

        println("Depth: ${maxDepth(root)}")
    }

    // Input: root = [1]
    private fun example3() {
        val root = TreeNode(1)

        println("Depth: ${maxDepth(root)}")

    }
}