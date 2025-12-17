package org.tty.leet_code

class Solution137 {
    fun singleNumber(nums: IntArray): Int {
        var result = 0
        for (i in 0 until 32) {
            var total = 0
            // 按位统计
            for (num in nums) {
                total += (num shr i) and 1
            }
            if (total % 3 > 0) {
                result = result or (1 shl i)
            }
        }
        return result
    }
}