package org.tty.leet_code

class Solution200 {
    fun numIslands(grid: Array<CharArray>): Int {
        val rowCount = grid.size
        val columnCount = grid[0].size

        /// BFS扫描
        fun mark(i: Int, j: Int) {
            grid[i][j] = '2'

            if (i < rowCount - 1) {
                if (grid[i + 1][j] == '1') {
                    mark(i + 1, j)
                }
            }
            if (j < columnCount - 1) {
                if (grid[i][j + 1] == '1') {
                    mark(i, j + 1)
                }
            }
            if (i > 0) {
                if (grid[i - 1][j] == '1') {
                    mark(i - 1, j)
                }
            }
            if (j > 0) {
                if (grid[i][j - 1] == '1') {
                    mark(i, j - 1)
                }
            }
        }

        var count = 0
        for (i in 0 until rowCount) {
            for (j in 0 until columnCount) {
                if (grid[i][j] == '1') {
                    mark(i, j)
                    count++
                }
            }
        }

        return count
    }

}