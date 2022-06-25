package org.tty.leet_code

import kotlin.math.min

/**
 * OfferSecond091: paint house, same as 256.
 *
 * English description is not available for the problem.
 *
 * **Solution:**
 *
 * use dp.
 *
 * when the i^th house is red, the totalCost could get by follow equivalent.
 * the blue or green is similar.
 * totalCost(r,i) = min(totalCost(g, i - 1) + totalCost(b, i - 1)) + costs(r, i)
 *
 * **Result:**
 * - time: 168ms: 50.00%
 * - memory: 38.7MB: 50.00%
 * - at 2022/6/25
 */
class SolutionOfferSecond091 {
    /**
     *
     * when the i^th house is red, the totalCost could get by follow equivalent.
     * the blue or green is similar.
     * totalCost(r,i) = min(totalCost(g, i - 1) + totalCost(b, i - 1)) + costs(r, i)
     */
    fun minCost(costs: Array<IntArray>): Int {
        val colorCount = 3
        val prev = intArrayOf(0, 0, 0)
        val cur = intArrayOf(0, 0, 0)
        fun moveCurToPrev() {
            for (i in 0 until colorCount) {
                prev[i] = cur[i]
            }
        }

        for (cost in costs) {
            moveCurToPrev()
            for (i in 0 until colorCount) {
                var minValue = Int.MAX_VALUE

                for(j in 0 until colorCount) {
                    if (i != j) { // color is different
                        minValue = min(minValue, prev[j])
                    }
                }
                cur[i] = (cost[i] + minValue)
            }
        }

        //return costResult.minOf { it } //not supported by judge.
        return minOf(cur[0], cur[1], cur[2])
    }
}