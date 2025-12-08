package org.tty.leet_code

class Solution73 {
    fun setZeroes(matrix: Array<IntArray>): Unit {
        val rowCount = matrix.size
        val columnCount = matrix[0].size

        val rowMarks = BooleanArray(rowCount) { false }
        val columnMarks = BooleanArray(columnCount) { false }

        for (i in 0 until rowCount) {
            for (j in 0 until columnCount) {
                if (matrix[i][j] == 0) {
                    rowMarks[i] = true
                    columnMarks[j] = true
                }
            }

            if (rowMarks[i]) {
                for (j in 0 until columnCount) {
                    matrix[i][j] = 0
                }
            }
        }

        for (j in 0 until columnCount) {
            if (columnMarks[j]) {
                for (i in 0 until rowCount) {
                    matrix[i][j] = 0
                }
            }
        }
    }
}