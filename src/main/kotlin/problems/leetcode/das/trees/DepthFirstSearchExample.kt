package problems.leetcode.das.trees

import problems.Problem

/**
 * This example shows DFS with pre-traversal order
 *
 *            0
 *       1         2
 *    3    4    x     5
 *   x x  x 6        x x
 */
class DepthFirstSearchExample : Problem {

    override fun execute() {
        val root = TreeNode(0)
        val t1 = TreeNode(1)
        t1.left = TreeNode(3)
        t1.right = TreeNode(4)
        t1.right?.right = TreeNode(6)
        val t2 = TreeNode(2)
        t2.right = TreeNode(5)
        root.left = t1
        root.right = t2

        // Traverse
        //preOrderTraverse(root)
        //inOrderTraverse(root)
        //postOrderTraverse(root)
    }
}
