package org.tty.leet_code

import kotlin.math.max

/**
 * 交错
 *
 * 方法2：找到所有的单调子序列，对每个子序列求值，然后处理中间的相同链。
 */
class Solution135 {
    fun candy(ratings: IntArray): Int {
        val leftCandies = IntArray(ratings.size) { 1 }

        for (i in 1 until ratings.size) {
            if (ratings[i] > ratings[i - 1]) {
                leftCandies[i] = leftCandies[i - 1] + 1
            }
        }

        var right = 1
        var sum = leftCandies[ratings.size - 1]

        for (i in (1 until ratings.size).reversed()) {
            if (ratings[i - 1] > ratings[i]) {
                right += 1
            } else {
                right = 1
            }

            sum += max(right, leftCandies[i - 1])
        }

        return sum
    }
}