package org.tty.leet_code

class Solution238 {
    fun productExceptSelf(nums: IntArray): IntArray {
        val lefts = IntArray(nums.size)
        val results = IntArray(nums.size)


        for (i in nums.indices) {
            if (i == 0) {
                lefts[i] = nums[i]
            } else {
                lefts[i] = lefts[i - 1] * nums[i]
            }
        }

        var right = 1
        for (i in nums.indices.reversed()) {
            if (i == 0) {
                results[i] = right
            } else {
                results[i] = right * lefts[i - 1]
                right *= nums[i]
            }
        }
        return results
    }
}