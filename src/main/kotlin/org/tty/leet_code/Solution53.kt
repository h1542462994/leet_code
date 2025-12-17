package org.tty.leet_code

import kotlin.math.max

class Solution53 {
    fun maxSubArray(nums: IntArray): Int {
        var sum = Int.MIN_VALUE
        var maxValue = Int.MIN_VALUE
        for (num in nums) {
            if (sum < 0) {
                sum = num
            } else {
                sum += num
            }
            maxValue = max(maxValue, sum)
        }
        return maxValue
    }
}