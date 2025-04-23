package problems.leetcode.das.trees

import org.junit.jupiter.api.Assertions
import kotlin.test.Test

class PathSumTest {

    val problemToTest = PathSum()

    @Test
    fun testScenario1() {
        // Given - Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
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

        // When
        val targetSum = 22
        val result = problemToTest.hasPathSum(root, targetSum)

        // Then - Expected = true
        Assertions.assertEquals(true, result)
    }

    @Test
    fun testScenario2() {
        // Given - Input = [1,2,3], targetSum = 5
        val root = TreeNode(1)
        root.left = TreeNode(2)
        root.right = TreeNode(3)

        // When
        val targetSum = 3
        val result = problemToTest.hasPathSum(root, targetSum)

        // Test - Expected True
        Assertions.assertTrue(result)
    }

    @Test
    fun testScenario3() {
        // Given - Input: [-2, null, -3]
        val root = TreeNode(-2)
        root.right = TreeNode(-3)

        // When
        val targetSum = -5
        val result = problemToTest.hasPathSum(root, targetSum)

        // Test
        Assertions.assertTrue(result)
    }

    @Test
    fun testScenario4() {
        // Given
        val root = TreeNode(1)
        root.left = TreeNode(2)

        // When
        val targetSum = 1
        val result = problemToTest.hasPathSum(root, targetSum)

        // Then
        Assertions.assertFalse(result)
    }
}