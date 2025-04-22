package problems.leetcode.das.trees

/**
 * Leetcode Problem: Minimum Depth of Binary Tree
 * URL: https://leetcode.com/problems/minimum-depth-of-binary-tree/editorial/
 *
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Note: A leaf is a node with no children.
 */
class MinimumDepthOfBinaryTree {

    /**
     * Determine the minDepth found in the tree
     * which root node is passed.
     *
     * @param root The node to be considered as root.
     * @return Int The min depth identified
     */
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
}