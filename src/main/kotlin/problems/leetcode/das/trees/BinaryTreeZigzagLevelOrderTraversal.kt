package problems.leetcode.das.trees

/**
 * Leetcode Problem: Binary tree zigzag level order traversal
 * URL: https://leetcode.com/explore/item/4621
 * URL: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/editorial/
 *
 * Given the root of a binary tree, return the zigzag level order
 * traversal of its nodes' values. (i.e., from left to right, then
 * right to left for the next level and alternate between).
 *
 * @constructor Create empty Binary tree zigzag level order traversal
 */
class BinaryTreeZigzagLevelOrderTraversal {

    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) {
            return emptyList()
        }

        // Create empty list to host the answer
        val answer = mutableListOf<List<Int>>()

        // Create the queue & add the root node
        val queue = ArrayDeque<TreeNode>()
        root.run {
            queue.add(this)
        }

        // Determine the level we are evaluating
        var level = 1

        // Check if there are more items in the queue
        while (queue.isNotEmpty()) {

            // Get the length of the queue
            val queueLength = queue.size
            val leftToRight = level.mod(2) == 0
            val levelNodes = mutableListOf<Int>()

            queue.forEach { element ->
                if (leftToRight) {
                    // Add to beginning
                    levelNodes.add(0, element.`val`)
                } else {
                    // Add to the end
                    levelNodes.add(element.`val`)
                }
            }
            answer.add(levelNodes)

            // Update queue with the children
            (0 until queueLength).forEach { _ ->

                // Remove element from the queue
                val first = queue.removeFirst()

                // Add its children to the queue
                first.left?.run {
                    queue.add(this)
                }
                first.right?.run {
                    queue.add(this)
                }
            }

            // Increase level
            level++
        }

        return answer
    }

}
