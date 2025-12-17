package org.tty.leet_code

class Solution35 {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var start = 0
        var end = nums.size

        var mid: Int
        while (start < end) {
            mid = (start + end) / 2
            if (target == nums[mid]) {
                return mid
            } else if (target < nums[mid]) {
                // left.
                end = mid
            } else {
                start = mid + 1
            }
        }
        return start
    }
}