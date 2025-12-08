package org.tty.leet_code

import kotlin.math.min

class Solution11 {
    fun maxArea(height: IntArray): Int {
        var l = 0
        var r = height.size - 1

        var maxL = height[l]
        var maxR = height[r]
        var max = r * min(height[l], height[r])

        while (l < r) {
            // 更新左柱子
            if (maxL <= maxR) {
                val cur = height[l + 1]
                if (cur > maxL) {
                    maxL = cur
                    val size = (r - l - 1) * min(cur, height[r])
                    if (size > max) {
                        max = size
                    }
                }
                l++
            } else {
                val cur = height[r - 1]
                if (cur > maxR) {
                    maxR = cur
                    val size = (r - 1 - l) * min(height[l],cur)
                    if (size > max) {
                        max = size
                    }
                }
                r--
            }
        }
        return max
    }
}