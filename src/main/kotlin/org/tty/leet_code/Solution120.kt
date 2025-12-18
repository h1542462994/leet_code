package org.tty.leet_code

import kotlin.math.min

class Solution120 {
    fun minimumTotal(triangle: List<List<Int>>): Int {
        val n = triangle.size
        val result = mutableListOf<MutableList<Int>>()
        result.add(mutableListOf(triangle[0][0]))

        for (i in 1 until n) {
            val list = mutableListOf<Int>()
            for (j in 0 .. i) {
                if (j == 0) {
                    list.add(result[i - 1][j] + triangle[i][j])
                } else if (j == i) {
                    list.add(result[i - 1][j - 1] + triangle[i][j])
                } else {
                    list.add(min(result[i - 1][j], result[i - 1][j - 1]) + triangle[i][j])
                }
            }
            result.add(list)
        }

        return result.last().minOf { it }
    }
}