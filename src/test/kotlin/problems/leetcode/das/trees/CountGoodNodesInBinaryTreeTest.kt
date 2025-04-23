package problems.leetcode.das.trees

import org.junit.jupiter.api.Assertions
import kotlin.test.Test

class CountGoodNodesInBinaryTreeTest {

    // Subject to test
    val problemToTest = CountGoodNodesInBinaryTree()

    @Test
    fun testScenario1() {
        // Given - Input: [3,1,4,3,null,1,5]
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

        // When
        val result = problemToTest.goodNodes(rootNode)

        // Then - Expected 4
        Assertions.assertEquals(4, result)
    }

    @Test
    fun testScenario2() {
        // Given - input: [2,null,4,10,8,null,null,4]
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

        // When
        val result = problemToTest.goodNodes(rootNode)

        // Then - Expected 4
        Assertions.assertEquals(4, result)
    }

    @Test
    fun testScenario3() {
        // Given - Input: [9,null,3,6]
        val rootNode = TreeNode(9)
        val node3 = TreeNode(3)
        val node6 = TreeNode(6)
        rootNode.right = node3
        node3.left = node6

        // When
        val result = problemToTest.goodNodes(rootNode)

        // Then - Expected ...
        Assertions.assertEquals(1, result)
    }
}