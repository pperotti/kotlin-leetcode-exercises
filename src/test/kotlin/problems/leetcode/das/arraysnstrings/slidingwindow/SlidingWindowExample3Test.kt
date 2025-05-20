package problems.leetcode.das.arraysnstrings.slidingwindow

import kotlin.test.Test
import kotlin.test.assertEquals

class SlidingWindowExample3Test {

    val subject = SlidingWindowExample3()

    @Test
    fun testScenario1() {
        // Given
        val nums = intArrayOf(10, 5, 2, 6)
        val k = 100

        // When
        val answer = subject.numSubarrayProductLessThanK(nums, k)

        // Then
        assertEquals(8, answer)
    }
}
