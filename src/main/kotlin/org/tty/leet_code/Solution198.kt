package org.tty.leet_code

import kotlin.math.max

class Solution198 {
    fun rob(nums: IntArray): Int {
        if (nums.size <= 2) {
            return nums.maxOf { it }
        }

        val result = IntArray(nums.size) { 0 }
        result[0] = nums[0]
        result[1] = max(nums[0], nums[1])

        for (i in 2 until nums.size) {
            result[i] = max(nums[i] + result[i - 2], result[i - 1])
        }
        return result[nums.size - 1]
    }
}