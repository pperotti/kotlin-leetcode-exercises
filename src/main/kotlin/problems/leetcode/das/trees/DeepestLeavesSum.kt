package problems.leetcode.das.trees

/**
 * Leetcode Problem: 1302. Deepest Leaves Sum
 * URL: https://leetcode.com/problems/deepest-leaves-sum/description/
 *
 * Given the root of a binary tree, return the sum of values of its deepest leaves.
 *
 * @constructor Create empty Deepest leaves sum
 */
class DeepestLeavesSum {

    fun deepestLeavesSum(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        var answer = 0

        val queue = ArrayDeque<TreeNode>()
        root.run {
            queue.add(this)
        }

        while (queue.isNotEmpty() ) {
            val queueLength = queue.size

            // Moment to calculate the answer
            var levelSum = 0
            queue.forEach {
                levelSum += it.`val`
            }
            answer = levelSum

            // Update queue
            (0 until queueLength).forEach { _ ->

                // Get the element
                val firstNode = queue.removeFirst()

                // Add children to the queue
                firstNode.left?.run {
                    queue.add(this)
                }
                firstNode.right?.run {
                    queue.add(this)
                }
            }
        }

        return answer
    }

}