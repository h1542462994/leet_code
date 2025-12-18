package org.tty.leet_code

class Solution63 {
    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
        val rowCount = obstacleGrid.size
        val columnCount = obstacleGrid[0].size

        val resultGrid = Array(rowCount) {
            IntArray(columnCount) { 0 }
        }
        if (obstacleGrid[0][0] == 1 || obstacleGrid[rowCount - 1][columnCount - 1] == 1) {
            return 0
        }

        resultGrid[0][0] = 1

        for (i in 0 until rowCount) {
            for (j in 0 until columnCount) {
                if (!(i == 0 && (j == 0))) {
                    if (obstacleGrid[i][j] == 1) {
                        resultGrid[i][j] = 0
                    } else {
                        val path1 = if (j == 0) 0 else resultGrid[i][j - 1]
                        val path2 = if (i == 0) 0 else resultGrid[i - 1][j]
                        resultGrid[i][j] = path1 + path2
                    }
                }
            }
        }
        return resultGrid[rowCount - 1][columnCount - 1]
    }
}