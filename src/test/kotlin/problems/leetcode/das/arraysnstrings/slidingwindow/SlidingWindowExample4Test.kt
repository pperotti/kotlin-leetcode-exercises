package problems.leetcode.das.arraysnstrings.slidingwindow

import kotlin.test.Test
import kotlin.test.assertEquals

class SlidingWindowExample4Test {

    val subject = SlidingWindowExample4()

    @Test
    fun testScenario1() {
        // Given
        val nums = intArrayOf(-3, -1, 4, 12, -8, 5, 6)
        val k = 4

        // When
        val answer = subject.findBestSubarray(nums, k)

        // Then
        assertEquals(15, answer)
    }
}