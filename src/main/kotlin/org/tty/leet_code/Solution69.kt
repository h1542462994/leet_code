package org.tty.leet_code

class Solution69 {
    fun mySqrt(x: Int): Int {
        var left = 0
        var right = x

        var ans = -1
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (mid.toLong() * mid.toLong() <= x.toLong()) {
                ans = mid
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        return ans
    }
}