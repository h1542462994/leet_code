package org.tty.leet_code

/**
 * 单调递增的值
 */
class Solution122 {
    fun maxProfit(prices: IntArray): Int {
        var result: Int = 0
        for (i in prices.indices) {
            if (i != 0) {
                val diff = prices[i] - prices[i - 1]
                if (diff > 0) {
                    result += diff
                }
            }
        }
        return result
    }
}