package problems.leetcode.das.arraysnstrings.slidingwindow

import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * Sliding window example1 test
 *
 * @constructor Create empty Sliding window example1 test
 */
class SlidingWindowExample1Test {

    val subject = SlidingWindowExample1()

    @Test
    fun testFindLengthScenario1() {
        // Given
        val k = 8
        val numbers: IntArray = intArrayOf(3, 1, 2, 7, 4, 2, 1, 1, 5)

        // When
        val answer = subject.findLength(numbers, k)

        // Then
        assertEquals(4, answer)
    }

}