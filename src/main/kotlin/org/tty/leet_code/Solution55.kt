package org.tty.leet_code

import kotlin.math.max

/**
 * 跳跃游戏
 */
class Solution55 {
    fun canJump(nums: IntArray): Boolean {
        // 记录当前阶可以达到的高度
        val levels = IntArray(nums.size)
        for (i in nums.indices) {
            levels[i] = nums[i] + i
        }

        // 从0开始，依次扩展
        var cur = 0
        var level = levels[0]
        while (true) {
            if (level >= nums.size - 1) {
                return true
            }

            // optimize
            for (i in 0 .. level) {
                level = max(level, levels[i])
            }

            if (cur >= level) {
                return false
            }

            cur = level // 更新起点
        }
    }

}