import problems.leetcode.das.arraysnstrings.slidingwindow.Example2
import problems.leetcode.das.arraysnstrings.slidingwindow.Example3
import problems.leetcode.das.arraysnstrings.slidingwindow.Example4

fun main() {
    //ProblemTwoSums().execute()
    //ProblemContainerWithMostWater().execute()
    //ProblemTrappingRainWater().execute()
    //ProblemReverseString().execute()
    //ProblemSquaresOfSortedArray().execute()
    //Example1().execute()
    //Example2().execute()
    //Example3().execute()
    Example4().execute()
}
/*
public int findBestSubarray(int[] nums, int k) {
    int curr = 0;
    for (int i = 0; i < k; i++) {
        curr += nums[i];
    }

    int ans = curr;
    for (int i = k; i < nums.length; i++) {
        curr += nums[i] - nums[i - k];
        ans = Math.max(ans, curr);
    }

    return ans;
}
 */