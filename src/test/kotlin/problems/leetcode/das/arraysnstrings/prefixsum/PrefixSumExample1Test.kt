package problems.leetcode.das.arraysnstrings.prefixsum

import kotlin.test.Test
import kotlin.test.assertContentEquals

/**
 * Test for "prefix sum example 1 test"
 *
 * @constructor Create empty Prefix sum example1 test
 */
class PrefixSumExample1Test {

    // Create the subject to test
    val subject = PrefixSumExample1()

    @Test
    fun testScenario1() {
        // Given
        val input = intArrayOf(1, 6, 3, 2, 7, 2)
        val queries = arrayOf(intArrayOf(0, 3), intArrayOf(2, 5), intArrayOf(2, 4))
        val limit = 13

        // When
        val answer = subject.answerQueries(
            numbers = input,
            queries = queries,
            limit = limit)

        // Then
        assertContentEquals(
            expected = booleanArrayOf(true, false, true),
            actual = answer
        )
    }
}