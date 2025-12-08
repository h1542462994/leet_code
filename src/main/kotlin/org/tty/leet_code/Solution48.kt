package org.tty.leet_code

class Solution48 {
    fun rotate(matrix: Array<IntArray>): Unit {
        val rowCount = matrix.size
        val columnCount = matrix[0].size

        // 对角线对换
        for (i in 0 until rowCount) {
            for (j in i + 1 until columnCount) {
                val k = matrix[i][j]
                matrix[i][j] = matrix[j][i]
                matrix[j][i] = k
            }
        }

        // 水平翻转
        for (i in 0 until rowCount) {
            for (j in 0 until columnCount / 2) {
                val k = matrix[i][j]
                matrix[i][j] = matrix[i][columnCount - 1 - j]
                matrix[i][columnCount - 1 - j] = k
            }
        }
    }
}