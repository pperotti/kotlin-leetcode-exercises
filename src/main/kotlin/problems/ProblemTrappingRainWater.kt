package problems

/**
 * ARRAYS PROBLEMS: Trapping Rain Water
 *
 * Given n non-negative integers representing an elevation map where
 * the width of each bar is 1, compute how much water it can trap
 * after raining.
 */
class ProblemTrappingRainWater : Problem {

    override fun execute() {

        val numbers = intArrayOf(0,1,0,2,1,0,1,3,2,1,2,1)
        println("Trap Water -> Solution #1: ${solution1(numbers)}")
        println("Trap Water -> Solution #2: ${solution2(numbers)}")

    }

    /**
     * Brute Force Solution: This solution uses one pointer to indicate how to iterate
     * over all the elements.
     *
     * TIME: O(n^2)
     * SPACE: O(1)
     */
    fun solution1(heights: IntArray): Int {

        var totalWater = 0
        for(i in heights.indices) {

            var leftP = i
            var rightP = i
            var maxLeft = 0
            var maxRight = 0

            while (leftP >= 0) {
                maxLeft = Math.max(maxLeft, heights[leftP])
                leftP--
            }

            while (rightP < heights.size) {
                maxRight = Math.max(maxRight, heights[rightP])
                rightP++
            }

            val currentWater = Math.min(maxLeft, maxRight) - heights[i]
            if (currentWater >= 0) {
                totalWater += currentWater
            }
        }
        return totalWater
    }

    /**
     * Optimized solution: This solution solves the problem by only iterating with
     * the following logic.
     *
     * 1. Identify pointer with lesser value
     * 2. Is this pointer value lesser than or equal to max on that side
     *  yes) update max on that side
     *  no) get water from pointer value, add to total
     * 3. Move pointer inwards
     * 4. repeat for other pointer.
     */
    fun solution2(heights: IntArray) : Int {
        var left = 0
        var right = heights.size - 1
        var maxLeft = 0
        var maxRight = 0
        var total = 0

        while (left < right) {
            if (heights[left] <= heights[right]) { //Evaluate left
                if (heights[left] >= maxLeft ) {
                    maxLeft = heights[left]
                } else {
                    total += maxLeft - heights[left]
                }
                left++
            } else { // Evaluate Right
                if (heights[right] >= maxRight) {
                    maxRight = heights[right]
                } else {
                    total += maxRight - heights[right]
                }
                right--
            }
        }
        return total
    }
}