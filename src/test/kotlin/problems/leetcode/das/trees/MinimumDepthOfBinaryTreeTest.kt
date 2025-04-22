package problems.leetcode.das.trees

import org.junit.jupiter.api.Assertions
import utils.dfsPreOrderTraverse

class MinimumDepthOfBinaryTreeTest {

    // Subject to test
    val problemToTest = MinimumDepthOfBinaryTree()

    /**
     * Given: root = [3,9,20,null,null,15,7]
     * When: minDepth(root)
     * Then: output == 2
     */
    @org.junit.jupiter.api.Test
    fun testScenario1() {

        // Given
        val rootNode = TreeNode(3)
        val node9 = TreeNode(9)
        val node20 = TreeNode(20)
        rootNode.left = node9
        rootNode.right = node20

        val node15 = TreeNode(15)
        val node7 = TreeNode(7)
        node20.left = node15
        node20.right = node7

        //dfsPreOrderTraverse(rootNode)

        // When
        val output = problemToTest.minDepth(rootNode)

        // Then
        Assertions.assertEquals(2, output)
    }

    /**
     * Given the following input: root = [2,null,3,null,4,null,5,null,6]
     * When executing: minDepth(root)
     * Then the output should be 5.
     */
    @org.junit.jupiter.api.Test
    fun testScenario2() {
        // Given
        val rootNode = TreeNode(2)
        val node3 = TreeNode(3)
        rootNode.right = node3

        val node4 = TreeNode(4)
        node3.right = node4

        val node5 = TreeNode(5)
        node4.right = node5

        val node6 = TreeNode(6)
        node5.right = node6

        //dfsPreOrderTraverse(rootNode)

        // When
        val output = problemToTest.minDepth(rootNode)

        // Then
        Assertions.assertEquals(5, output)
    }
}