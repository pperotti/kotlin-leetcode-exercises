package problems.leetcode.das.trees

/**
 * Leetcode Problem: 1448. Count Good Nodes in Binary Tree
 * URL: https://leetcode.com/problems/count-good-nodes-in-binary-tree/description/
 *
 * Given a binary tree root, a node X in the tree is named good
 * if in the path from root to X there are no nodes with a value
 * greater than X.
 *
 * Return the number of good nodes in the binary tree.
 */
class CountGoodNodesInBinaryTree {

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
        findGoodNodes(root, result, root.`val`)

        return result.goodNodesCount
    }

    private fun findGoodNodes(node: TreeNode?, result: Result, maxElement: Int) {
        if (node == null) {
            return
        }

        val currValue = node.`val`

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
