package problems.leetcode.das.trees

import org.junit.jupiter.api.Assertions
import kotlin.test.Test

class DiameterOfBinaryTreeTest {

    val problemToSolve = DiameterOfBinaryTree()

    @Test
    fun testScenario1() {
        // Given - [1,2,3,4,5]
        val root = TreeNode(1)
        val n2 = TreeNode(2)
        val n3 = TreeNode(3)

        root.left = n2
        root.right = n3

        val n4 = TreeNode(4)
        val n5 = TreeNode(5)
        n2.left = n4
        n2.right = n5

        // When
        val result = problemToSolve.diameterOfBinaryTree(root)

        // Then - Expected = 3
        Assertions.assertEquals(3, result)
    }

    @Test
    fun testScenario2() {
        // Given - [1,2]
        val root = TreeNode(1)
        val n2 = TreeNode(2)

        root.left = n2

        // When
        val result = problemToSolve.diameterOfBinaryTree(root)

        // Then - Expected: 1
        Assertions.assertEquals(1, result)
    }

    @Test
    fun testScenario3() {
        // Given -
        val root = TreeNode(8)
        val n7 = TreeNode(-1)
        val n3 = TreeNode(3)
        root.left = n7
        root.right = n3

        val n9 = TreeNode(-9)
        val n3_2 = TreeNode(-3)
        n3.left = n9
        n3.right = n3_2

        val n9_2 = TreeNode(-9)
        val n7_2 = TreeNode(-7)
        n9.left = n9_2
        n9.right = n7_2

        val n6 = TreeNode(6)
        n9_2.left = n6

        val n6_2 = TreeNode(6)
        val n0 = TreeNode(0)
        n6.left = n0
        n6.right = n6_2

        val n1 = TreeNode(-1)
        val n4 = TreeNode(-4)
        n0.right = n1
        n6_2.left = n4

        val n6_3 = TreeNode(-6)
        val n6_4 = TreeNode(-6)
        n7_2.left = n6_3
        n7_2.right = n6_4

        val n5 = TreeNode(5)
        n6_3.left = n5

        val n9_3 = TreeNode(9)
        val n2_2 = TreeNode(2)
        n6_4.left = n9_3
        n9_3.left = n2_2

        // When
        val result = problemToSolve.diameterOfBinaryTree(root)

        // Then - Expected: 8
        Assertions.assertEquals(8, result)
    }
}