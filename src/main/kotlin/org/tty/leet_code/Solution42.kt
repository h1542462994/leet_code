package org.tty.leet_code

import kotlin.math.max
import kotlin.math.min

class Solution42 {
    fun trap(height: IntArray): Int {
        // 左边界
        val leftBounds = IntArray(height.size)

        leftBounds[0] = height[0]
        for (i in 1 until height.size) {
            leftBounds[i] = max(leftBounds[i - 1], height[i])
        }

        var rightBound = height[height.size - 1]

        var sum = 0
        for (i in (1 until height.size - 1).reversed()) {
            rightBound = max(rightBound, height[i])

            // 能积的值为左右边界的最小值减去当前值。
            sum += min(leftBounds[i], rightBound) - height[i]
        }

        return sum
    }
}