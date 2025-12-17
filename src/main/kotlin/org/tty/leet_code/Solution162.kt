package org.tty.leet_code

class Solution162 {
    fun findPeakElement(nums: IntArray): Int {
        if (nums.size == 1) {
            return 0
        }

        var start = 0
        var end = nums.size

        fun judgePeak(index: Int): Int {
            if (index == 0) {
                return if (nums[1] > nums[0]) 1 else 0
            } else if (index == nums.size - 1) {
                return if (nums[nums.size - 2] > nums[nums.size - 1]) -1 else 0
            }

            val left = nums[index - 1]
            val right = nums[index + 1]
            val mid = nums[index]

            if (left < mid && mid < right) {
                return 1
            } else if (left > mid && mid > right) {
                return -1
            } else if (left > mid && mid < right) {
                return 1
            }
            return 0
        }

        var mid: Int
        while (start < end) {
            mid = (start + end) / 2

            val judge = judgePeak(mid)
            if (judge == 0) { // find peak.
                return mid
            } else if (judge < 0) { // exists left.
                end = mid
            } else {
                start = mid + 1
            }
        }
        return -1
    }
}