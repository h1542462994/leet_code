package org.tty.leet_code

import kotlin.math.max
import kotlin.math.min

class Solution123 {
    fun maxProfit(prices: IntArray): Int {
        val n = prices.size

        val lefts = IntArray(n)
        var minValue = prices[0]
        lefts[0] = 0

        for (i in 1 until n) {
            // 要么今天不抛售，要么抛售
            lefts[i] = max(lefts[i - 1], prices[i] - minValue)
            minValue = min(minValue, prices[i])
        }

        val rights = IntArray(n)
        var maxValue = prices[n - 1]
        rights[n - 1] = 0

        for (i in (0 until n - 1).reversed()) {
            rights[i] = max(rights[i + 1], maxValue - prices[i])
            maxValue = max(maxValue, prices[i])
        }

        // 这样就分成了左右两端。
        var maxResult = lefts[0] + rights[0]
        for (i in 1 until n) {
            val r = lefts[i] + rights[i]
            if (r > maxResult) {
                maxResult = r
            }
        }
        return maxResult

    }
}