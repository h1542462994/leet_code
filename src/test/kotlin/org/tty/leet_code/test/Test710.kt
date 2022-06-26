package org.tty.leet_code.test

import org.junit.jupiter.api.Test
import org.tty.leet_code.Solution710
import org.tty.leet_code.Solution710V2

class Test710 {
    @Test
    fun test710() {
        val n = 7
        val blackList = intArrayOf(2, 3, 5)
        val solution = Solution710V2(n, blackList)

        val count = 100000
        val resultMap = mutableMapOf<Int, Int>()
        for (i in 0 until count) {
            val result = solution.pick()
            resultMap[result] = resultMap.getOrDefault(result, 0) + 1
        }

        for (i in 0 until n) {
            println("${i}: ${resultMap.getOrDefault(i, 0) / count.toDouble()}")
        }
    }
}