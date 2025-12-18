package org.tty.leet_code

import kotlin.math.min

class Solution322 {
    class Memory {
        val coinsCountMap = mutableMapOf<Int, Int?>()
    }

    fun coinChange(coins: IntArray, amount: Int): Int {
        val memory = Memory()
        return get(coins, amount, memory) ?: -1
    }

    fun get(coins: IntArray, amount: Int, memory: Memory): Int? {
        if (amount == 0) {
            return 0
        }

        if (memory.coinsCountMap.contains(amount)) {
            return memory.coinsCountMap[amount]
        }

        var minCount: Int? = null
        for (coin in coins) {
            val remain = amount - coin
            if (remain == 0) {
                minCount = 1
            } else if (remain > 0) {
                val count = get(coins, remain, memory)
                if (count != null) {
                    minCount = if (minCount == null) {
                        (count + 1)
                    } else {
                        min(minCount, (count + 1))
                    }
                }
            }
        }

        memory.coinsCountMap.put(amount, minCount)
        return minCount
    }


}