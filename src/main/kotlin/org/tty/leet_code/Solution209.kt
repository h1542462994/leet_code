package org.tty.leet_code

class Solution209 {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var l = 0
        var r = 1

        var sum = nums[0]
        var minLength: Int? = null

        while (r <= nums.size) {
            if (sum >= target) {
                if (minLength == null || (r - l) < minLength) {
                    minLength = r - l
                }
            }

            if (sum < target) {
                if (r < nums.size) {
                    sum += nums[r]
                }
                r++
            } else {
                if (r - l > 1) {
                    sum -= nums[l]
                    l++
                } else {
                    l++
                    r++
                    if (l < nums.size) {
                        sum = nums[l]
                    }

                }
            }
        }

        return minLength ?: 0
    }
}