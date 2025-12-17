package org.tty.leet_code

import kotlin.math.max
import kotlin.math.min

class Solution918 {
    fun maxSubarraySumCircular(nums: IntArray): Int {
        if (nums.all { it < 0 }) { // 全部为负数，则返回最大的负数即可
            return nums.maxOf { it }
        }

        var totalSum = 0
        var minSum = Int.MAX_VALUE
        var minValue = Int.MAX_VALUE
        var maxSum = Int.MIN_VALUE
        var maxValue = Int.MIN_VALUE

        for (num in nums) {
            totalSum += num

            maxSum = if (maxSum <= 0) {
                num
            } else {
                maxSum + num
            }
            maxValue = max(maxValue, maxSum)

            minSum = if (minSum >= 0) {
                num
            } else {
                minSum + num
            }
            minValue = min(minValue, minSum)
        }

        return max(maxValue, totalSum - minValue)
    }
}