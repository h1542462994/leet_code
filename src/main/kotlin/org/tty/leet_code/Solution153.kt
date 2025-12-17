package org.tty.leet_code

class Solution153 {
    fun findMin(nums: IntArray): Int {
        if (nums[0] <= nums[nums.size - 1]) {
            return nums[0]
        }

        val pa = nums[0]
        val pb = nums[nums.size - 1]

        var a = 0
        var b = nums.size

        var mid: Int

        while (a < b) {
//            mid = (a + b) / 2
            mid = a + (b - a) / 2 // 防止爆int

            val cur = nums[mid]
            if (cur < nums[mid - 1]) {
                return cur
            } else if (cur > pa) {
                // right part.
                a = mid + 1
            } else {
                b = mid
            }
        }
        return -1
    }
}