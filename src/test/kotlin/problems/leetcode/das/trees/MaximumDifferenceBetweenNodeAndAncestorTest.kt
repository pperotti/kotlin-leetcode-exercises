package problems.leetcode.das.trees

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class MaximumDifferenceBetweenNodeAndAncestorTest {

    val problemToTest = MaximumDifferenceBetweenNodeAndAncestor()

    @Test
    fun testScenario1() {
        // Given -
        val rootNode = TreeNode(8)
        val r3 = TreeNode(3)
        val r10 = TreeNode(10)
        rootNode.left = r3
        rootNode.right = r10

        val r1 = TreeNode(1)
        val r6 = TreeNode(6)
        r3.left = r1
        r3.right = r6

        val r4 = TreeNode(4)
        val r7 = TreeNode(7)
        r6.left = r4
        r6.right = r7

        val r14 = TreeNode(14)
        r10.right = r14

        val r13 = TreeNode(13)
        r14.left = r13

        // When
        val result = problemToTest.maxAncestorDiff(rootNode)
        println(result)

        // Then
        Assertions.assertEquals(7, result)
    }

    @Test
    fun testScenario2() {

        // Given
        val root = TreeNode(1)
        val n2 = TreeNode(2)
        val n0 = TreeNode(0)
        val n3 = TreeNode(3)
        root.right = n2
        n2.right = n0
        n0.left = n3

        // When
        val result = problemToTest.maxAncestorDiff(root)

        // Then
        Assertions.assertEquals(3, result)
    }

    @Test
    fun testScenario3() {
        // Given - [2,5,0,null,null,4,null,null,6,1,null,3]
        val root = TreeNode(2)
        val n5 = TreeNode(5)
        val n0 = TreeNode(0)
        root.left = n5
        root.right = n0

        val n4 = TreeNode(4)
        n0.left = n4

        val n6 = TreeNode(6)
        n4.right = n6

        val n1 = TreeNode(1)
        n6.left = n1

        val n3 = TreeNode(3)
        n1.left = n3

        // When
        val result = problemToTest.maxAncestorDiff(root)

        // Then
        Assertions.assertEquals(6, result)
    }

    @Test
    fun testScenario4() {
        // Given - [2,4,3,1,null,0,5,null,6,null,null,null,7]
        val root = TreeNode(2)
        val n4 = TreeNode(4)
        val n3 = TreeNode(3)
        root.left = n4
        root.right = n3

        val n1 = TreeNode(1)
        n4.left = n1

        val n6 = TreeNode(6)
        n1.right = n6

        val n0 = TreeNode(0)
        val n5 = TreeNode(5)
        n3.left = n0
        n3.right = n5

        val n7 = TreeNode(7)
        n5.right = n7

        // When
        val result = problemToTest.maxAncestorDiff(root)

        // Then
        Assertions.assertEquals(5, result)
    }

    @Test
    fun testScenario5() {
        // Given - [8,3,10,1,6,null,14,null,null,4,7,13]
        val root = TreeNode(8)
        val n3 = TreeNode(3)
        val n10 = TreeNode(10)
        root.left = n3
        root.right = n10

        val n1 = TreeNode(1)
        val n6 = TreeNode(6)
        n3.left = n1
        n3.right = n6

        val n4 = TreeNode(4)
        val n7 = TreeNode(7)

        n6.left = n4
        n6.right = n7

        val n14 = TreeNode(14)
        n10.right = n14

        val n13 = TreeNode(13)
        n14.left = n13

        // When
        val result = problemToTest.maxAncestorDiff(root)

        // Then
        Assertions.assertEquals(7, result)
    }
}