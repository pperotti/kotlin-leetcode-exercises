package problems

/**
 * ARRAYS PROBLEMS: Container with Most Water.
 * http://leetcode.com/problems/container-with-most-water/
 *
 * You are given an array of positive integers where each integer represents the height of a vertical line on a chart.
 * FIND TWO LINES which together with the x-axis forms a container that would hold the greatest amount of water.
 * Return the area of water it would hold.
 */
class ProblemContainerWithMostWater : Problem {

    override fun execute() {
//        val numbers = intArrayOf(3,5,6,4,7)
        val numbers = intArrayOf(7,1,2,3,9)
        println("Best Area: ${solution1(numbers)}")
        println("Best Area: ${solution2(numbers)}")
    }


    /**
     * The obvious solution is the brute-force solution where you will iterate the num array twice using a nested loop.
     *
     * TIME: O(n^2)
     * SPACE: O(1)
     */
    private fun solution1(nums: IntArray) : Int {
        var maxArea = 0
        for (i in nums.indices) {
            for (j in i+1 until nums.size) {
                var height = Math.min(nums[i], nums[j])
                var width = j - i
                val area = width * height
                println("Pair: (${nums[i]}, ${nums[j]})=$area")
                maxArea = Math.max(maxArea, area)
            }
        }
        return maxArea
    }

    /**
     * The optimal solution transform the O(n^2) into a O(n) solution.
     *
     * To achieve this it will use a TWO POINTERS TECHNIQUE which helps you traverse an array using more than one pointer
     * at a time.
     *
     * TIME: O(N)
     * SPACE: O(1)
     */
    private fun solution2(nums: IntArray) : Int {
        var maxArea = 0

        println("Array ${nums.contentToString()}")

        // Here, we are going to use 2 pointers, the first one pointing to the first position, another one pointing
        // to the last. The logic consists in calculating the area for the 2 current indexes, compare it with the biggest
        // area stored. This is repeated until the indexes meets in the middle of the array.
        var leftPointer = 0
        var rightPointer = nums.size - 1

        while (leftPointer < rightPointer) {

            val height = Math.min(nums[leftPointer], nums[rightPointer])
            val width = rightPointer - leftPointer
            val area = height * width
            maxArea = Math.max(maxArea, area)

            println("LP: $leftPointer RP: $rightPointer Width: $width Height: $height -> area: $area")

            if (nums[leftPointer] <= nums[rightPointer]) {
                leftPointer++
            } else {
                rightPointer--
            }
        }

        return maxArea
    }

}