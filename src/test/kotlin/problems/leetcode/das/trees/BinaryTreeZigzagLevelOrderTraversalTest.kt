package problems.leetcode.das.trees

import org.junit.jupiter.api.Assertions
import utils.buildTreeFromArrayList
import kotlin.test.Test

class BinaryTreeZigzagLevelOrderTraversalTest {

    val problemToSolve = BinaryTreeZigzagLevelOrderTraversal()

    @Test
    fun testScenario1() {

        // Given - root = [3,9,20,null,null,15,7]
        val elements: ArrayList<Int?> = arrayListOf(3, 9, 20, null, null, 15, 7)
        val root = buildTreeFromArrayList(elements)

        // When
        val output = problemToSolve.zigzagLevelOrder(root)

        // Test - [[3],[20,9],[15,7]]
        val expectedOutput = listOf(listOf(3), listOf(20, 9), listOf(15, 7))
        println(expectedOutput)
        println(output)
        Assertions.assertEquals(expectedOutput.size, output.size)
        expectedOutput.forEachIndexed { index, element ->
            Assertions.assertArrayEquals(element.toIntArray(), output.getOrNull(index)?.toIntArray())
        }
    }

    @Test
    fun testScenario2() {

        // Given - root = [1]
        val elements: ArrayList<Int?> = arrayListOf(1)
        val root = buildTreeFromArrayList(elements)

        // When
        val output = problemToSolve.zigzagLevelOrder(root)

        // Test - [[1]]
        val expectedOutput = listOf(listOf(1))
        println(expectedOutput)
        println(output)
        Assertions.assertEquals(expectedOutput.size, output.size)
        expectedOutput.forEachIndexed { index, element ->
            Assertions.assertArrayEquals(element.toIntArray(), output.getOrNull(index)?.toIntArray())
        }
    }

    @Test
    fun testScenario3() {

        // Given - root = []
        val elements: ArrayList<Int?> = arrayListOf()
        val root = buildTreeFromArrayList(elements)

        // When
        val output = problemToSolve.zigzagLevelOrder(root)

        // Test - []
        val expectedOutput = emptyList<List<Int>>()
        println(expectedOutput)
        println(output)
        Assertions.assertEquals(expectedOutput.size, output.size)
        expectedOutput.forEachIndexed { index, element ->
            Assertions.assertArrayEquals(element.toIntArray(), output.getOrNull(index)?.toIntArray())
        }
    }

    @Test
    fun testScenario4() {
        // Given - root = [1]
        val elements: ArrayList<Int?> = arrayListOf(1)
        val root = buildTreeFromArrayList(elements)

        // When
        val output = problemToSolve.zigzagLevelOrder(root)

        // Test - [[]]
        val expectedOutput = listOf(listOf(1))
        println(expectedOutput)
        println(output)
        Assertions.assertEquals(expectedOutput.size, output.size)
        expectedOutput.forEachIndexed { index, element ->
            Assertions.assertArrayEquals(element.toIntArray(), output.getOrNull(index)?.toIntArray())
        }
    }
}