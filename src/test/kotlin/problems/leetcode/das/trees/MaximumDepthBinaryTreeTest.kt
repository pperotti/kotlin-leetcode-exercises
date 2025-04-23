package problems.leetcode.das.trees

import org.junit.jupiter.api.Assertions
import kotlin.test.Test

class MaximumDepthBinaryTreeTest {

    // Subject to test
    val problemToTest = MaximumDepthBinaryTree()

    @Test
    fun testScenario1() {
        // Given - root = [3,9,20,null,null,15,7]
        val root = TreeNode(3)
        root.left = TreeNode(9)
        root.right = TreeNode(20)
        root.right?.left = TreeNode(15)
        root.right?.right = TreeNode(7)

        // When
        val result = problemToTest.maxDepth(root)

        // Then - Expected 3
        Assertions.assertEquals(3, result)
    }

    @Test
    fun testScenario2() {
        // Given - root = [1,null,2]
        val root = TreeNode(1)
        root.right = TreeNode(2)

        // When
        val result = problemToTest.maxDepth(root)

        // Then - Expected: 2
        Assertions.assertEquals(2, result)
    }

    @Test
    fun testScenario3() {
        // Given - root = [1]
        val root = TreeNode(1)

        // When
        val result = problemToTest.maxDepth(root)

        // Then
        Assertions.assertEquals(1, result)
    }
}