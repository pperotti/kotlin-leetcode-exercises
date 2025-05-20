package problems.leetcode.das.arraysnstrings.slidingwindow

import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * Sliding window example2 test
 *
 * @constructor Create empty Sliding window example2 test
 */
class SlidingWindowExample2Test {

    val subject = SlidingWindowExample2()

    @Test
    fun testFindLengthScenario1() {
        // Given
        val chain = "1101100111"

        // When
        val answer = subject.findLength(chain)

        // Then
        assertEquals(5, answer)
    }
}