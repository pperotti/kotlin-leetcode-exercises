package problems

import utils.printContents

/**
 * Problem: Two Sums
 *
 * Given an array with positive numbers and a target number, create a function that return
 * a pair of the first 2 numbers that sums the target value.
 */
class ProblemTwoSums : Problem {
    override fun execute() {
        println("Running Two Sums!!!")
        val numbers = intArrayOf(3,5,6,4,7)
        val target = 11

        // Solution 1
        printContents(solution1(numbers, target))

        // Solution 2
        printContents(solution2(numbers, target))
    }

    /**
     * Solution #1: we iterate numbers twice using brute force.
     *
     * TIME: O(n^2): Because it uses nested loops. It depends on
     * SPACE: O(1): It does not use extra memory beside temporary variables
     *              which do not depend on the var size.
     */
    fun solution1(numbers: IntArray, target: Int): IntArray {
        val identifiedPair = mutableListOf<Int>()
        outer@ for(i in numbers.indices) {
            for (j in i+1 until numbers.size) { // Iterate in a range of indexes
                println("numbers[$i]=${numbers[i]} + numbers[$j]=${numbers[j]} = ${numbers[i]+numbers[j]}" )
                if (target - numbers[i] == numbers[j]) {
                    identifiedPair.add(i)
                    identifiedPair.add(j)
                    break@outer // If we want to find all pairs, we should remove this break
                }
            }
        }
        return identifiedPair.toIntArray()
    }

    /**
     * We create a map and we iterate the array twice.
     *
     * TIME: O(n): We iterate over all elements once (worst case scenario)
     * SPACE: O(n): We create a map of size 'n' (worst case scenario)
     */
    fun solution2(numbers: IntArray, target: Int): IntArray {
        val identifiedPair = mutableListOf<Int>()
        val diffMap = mutableMapOf<Int, Int>()

        //First Pass, we calculate all the differences
        for (i in numbers.indices) {
            val diffWithTarget = target - numbers[i]
            val mapValue = diffMap.getOrDefault(numbers[i], -1)
            println("numbers[$i]=${numbers[i]} diffWithTarget=$diffWithTarget mapValue=$mapValue" )

            // If the map contains the value, we are done
            if (diffMap.containsKey(numbers[i])) {
                identifiedPair.add(mapValue)
                identifiedPair.add(i)
                break
            } else {
                diffMap[diffWithTarget] = i
            }
        }
        return identifiedPair.toIntArray()
    }

}