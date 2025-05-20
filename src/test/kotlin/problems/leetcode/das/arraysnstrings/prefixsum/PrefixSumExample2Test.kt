package problems.leetcode.das.arraysnstrings.prefixsum

import kotlin.test.Test
import kotlin.test.assertEquals

class PrefixSumExample2Test {

    val subject = PrefixSumExample2()

    @Test
    fun testScenario1() {
        // Given
        val numbers = intArrayOf(1, 6, 3, 2, 7, 2)

        // When
        val answer1 = subject.waysToSplitArray1(numbers)
        val answer2 = subject.waysToSplitArray2(numbers)

        // Then
        assertEquals(2, answer1)
        assertEquals(2, answer2)
    }
}