package problems.leetcode.das.utils

import org.junit.jupiter.api.Assertions
import utils.buildTreeFromArrayList
import utils.dfsPreOrderTraverse
import kotlin.test.Test

class TreeUtilsTest {

    @Test
    fun testBuildTreeScenario1() {
        // Given - [1,2,3,4,5]
        val elements : ArrayList<Int?> = arrayListOf(1,2,3,4,5)

        // Test
        val root = buildTreeFromArrayList(elements)

        // Validates
        val results = ArrayList<Int>()
        dfsPreOrderTraverse(root, results)
        val expected = intArrayOf(1,2,4,5,3)
        Assertions.assertArrayEquals(expected, results.toIntArray())
    }

    fun testBuildTreeScenario2() {

    }
}