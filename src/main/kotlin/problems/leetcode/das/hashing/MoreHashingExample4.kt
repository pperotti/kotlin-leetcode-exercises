package problems.leetcode.das.hashing

import problems.Problem

/**
 * Example 4: 2352. Equal Row and Column Pairs
 *
 * Given an n x n matrix grid, return the number of pairs (R, C) where R is a row and C is a column,
 * and R and C are equal if we consider them as 1D arrays.
 */
class MoreHashingExample4 : Problem {
    override fun execute() {
        // [[3,2,1],[1,7,6],[2,7,7]]
        val input = arrayOf<IntArray>(
            intArrayOf(3,2,1),
            intArrayOf(1,7,6),
            intArrayOf(2,7,7)
        )
        println("Input: ${input.contentDeepToString()}")
        println("Output: ${equalPairs(input)}")
    }

    private fun equalPairs(grid: Array<IntArray>): Int {
        val maxItems = grid.size
        var pairsCount = 0

        // Prepare ROWS DATA (the are in the input)
        println("Row Data: ${grid.contentDeepToString()}")

        // Prepare COLS DATA
        val cols = arrayOfNulls<IntArray>(maxItems)
        for (row in 0 until maxItems) {
            val colData = IntArray(maxItems)
            for (col in 0 until maxItems) {
                colData[col] = grid[col][row]
            }
            cols[row] = colData
        }
        println("Cols Data: ${cols.contentDeepToString()}")

        // Compare Data between arrays
        grid.forEach { row ->
            cols.forEach { col ->
                if (row.contentEquals(col)) {
                    pairsCount++
                }
            }
        }

        return pairsCount
    }
}