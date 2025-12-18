package org.tty.leet_code

import kotlin.math.min

class Solution64 {
    fun minPathSum(grid: Array<IntArray>): Int {
        // 对角线dp.
        val rowCount = grid.size
        val columnCount = grid[0].size
        val result = Array(rowCount) {
            IntArray(columnCount) { 0 }
        }
        result[0][0] = grid[0][0]
        for (k in 1 until rowCount + columnCount - 1) {
            for (i in 0 until rowCount) {
                val j = k - i
                if (j < 0 || j >= columnCount) {
                    continue
                }

                if (i == 0) {
                    result[i][j] = result[i][j - 1] + grid[i][j]
                } else if (j == 0) {
                    result[i][j] = result[i - 1][j] + grid[i][j]
                } else {
                    result[i][j] = min(result[i][j - 1], result[i - 1][j]) + grid[i][j]
                }
            }
        }
        return result[rowCount - 1][columnCount - 1]
    }
}