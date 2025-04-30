package problems.leetcode.das.trees

import org.junit.jupiter.api.Assertions
import utils.buildTreeFromArrayList
import utils.dfsPreOrderTraverse
import kotlin.test.Test

class DeepestLeavesSumTest {

    val problemToTest = DeepestLeavesSum()

    @Test
    fun testScenario1() {

        // Given - root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
        val elements : ArrayList<Int?> = arrayListOf(1,2,3,4,5,null,6,7,null,null,null,null,8)
        val root = buildTreeFromArrayList(elements)

        // Build Tree
        val results = ArrayList<Int>()
        dfsPreOrderTraverse(root, results)

        // When
        val output = problemToTest.deepestLeavesSum(root)

        // Assert - Output: 15
        Assertions.assertArrayEquals(intArrayOf(1,2,4,7,5,3,6,8), results.toIntArray())
        Assertions.assertEquals(15, output)

    }

    @Test
    fun testScenario2() {

        // Given - root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
        val elements : ArrayList<Int?> = arrayListOf(6,7,8,2,7,1,3,9,null,1,4,null,null,null,5)
        val root = buildTreeFromArrayList(elements)

        // Build Tree
        val results = ArrayList<Int>()
        dfsPreOrderTraverse(root, results)

        // When
        val output = problemToTest.deepestLeavesSum(root)
        println(results)

        // Assert - Output: 15
        Assertions.assertArrayEquals(intArrayOf(6, 7, 2, 9, 7, 1, 4, 8, 1, 3, 5), results.toIntArray())
        Assertions.assertEquals(19, output)
    }
}