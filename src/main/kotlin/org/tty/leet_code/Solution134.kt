package org.tty.leet_code

/**
 * 贪心：前n缀和
 */
class Solution134 {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        var index = 0
        val length = gas.size

        while (index < gas.size) {
            // 内部环绕
            var g = gas[index]
            var flag = true
            for (i in gas.indices) {
                if (g >= cost[(index + i) % length]) {
                    g = g - cost[(index + i) % length] + gas[(index + i + 1) % length]
                } else {
                    index = index + i + 1
                    flag = false
                    break
                }
            }
            if (flag) {
                return index
            }
        }
        return -1
    }
}

/**
 * 从0开始出发，累计最小的值为出发的点
 */
class Solution134V2 {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        var minValue: Int? = null
        var minIndex = -1

        var fuel = 0
        for (i in gas.indices) {
            fuel = fuel + gas[i] - cost[i]

            if (minValue == null || fuel < minValue) {
                minValue = fuel
                minIndex = i
            }
        }

        return if (fuel < 0) {
            -1
        } else {
            (minIndex + 1) % gas.size
        }
    }
}