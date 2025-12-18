package org.tty.leet_code

import kotlin.math.max

class Solution300 {
    fun lengthOfLIS(nums: IntArray): Int {
        val f = IntArray(nums.size) { 0 }
        f[0] = 1

        for (i in 1 until nums.size) {
            var maxValue = 0
            for (j in 0 until i) {
                if (nums[j] < nums[i]) {
                    maxValue = max(maxValue, f[j])
                }
            }
            f[i] = maxValue + 1
        }
        return f.maxOf { it }
    }
}