package problems.leetcode.das.trees

import problems.Problem

/**
 * 1448. Count Good Nodes in Binary Tree
 * URL: https://leetcode.com/problems/count-good-nodes-in-binary-tree/description/
 *
 * Given a binary tree root, a node X in the tree is named good
 * if in the path from root to X there are no nodes with a value
 * greater than X.
 *
 * Return the number of good nodes in the binary tree.
 */
class CountGoodNodesInBinaryTree : Problem {

    override fun execute() {
        example1()
        //example2()
        //example3()
    }

    private fun example1() {
        // Input: [3,1,4,3,null,1,5]
        // Expected: 4
        val rootNode = TreeNode(3)
        val node1 = TreeNode(1)
        val node4 = TreeNode(4)
        rootNode.left = node1
        rootNode.right = node4
        val node3_2 = TreeNode(3)
        node1.left = node3_2
        val node1_2 = TreeNode(1)
        val node5 = TreeNode(5)
        node4.left = node1_2
        node4.right = node5

        //DepthFirstSearchExample().preOrderTraverse(rootNode)

        val count = goodNodes(rootNode)
        println("Count: $count")
    }

    private fun example2() {
        //[2,null,4,10,8,null,null,4]
        // Expected: 4
        val node2 = TreeNode(2)
        val node4 = TreeNode(4)
        node2.right = node4

        val node10 = TreeNode(10)
        val node8 = TreeNode(8)
        node4.left = node10
        node4.right = node8

        val node4_2 = TreeNode(4)
        node8.left = node4_2

        val rootNode = node2

        DepthFirstSearchExample().preOrderTraverse(rootNode)

        val count = goodNodes(rootNode)
        println("Count: $count")
    }

    private fun example3() {
        // [9,null,3,6]
        val rootNode = TreeNode(9)
        val node3 = TreeNode(3)
        val node6 = TreeNode(6)
        rootNode.right = node3
        node3.left = node6

        val count = goodNodes(rootNode)
        println("Count: $count")
    }

    /**
     * Traverse from Root to leaf trying to find if
     * there is a path where all nodes have values
     * lower than the value of the leaf and greater
     * than the root node
     */
    fun goodNodes(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }

        // Set Response Container
        val result = Result(0)

        // Start iterating finding
        findGoodNodes(root, result, root.value)

        return result.goodNodesCount
    }

    private fun findGoodNodes(node: TreeNode?, result: Result, maxElement: Int) {
        if (node == null) {
            return
        }

        val currValue = node.value

        // Compare current value with the previous one
        if (maxElement <= currValue) {
            result.goodNodesCount++
        }

        // Determine the next element to avoid running max twice
        val nextMaxElement = Math.max(maxElement, currValue)

        // Search Left
        findGoodNodes(node.left, result, nextMaxElement)

        // Search Right
        findGoodNodes(node.right, result, nextMaxElement)
    }
}

// This can be omitted if we use a class member
class Result(
    var goodNodesCount: Int = 0
)
