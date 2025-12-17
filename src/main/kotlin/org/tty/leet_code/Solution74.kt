package org.tty.leet_code

class Solution74 {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val rowCount = matrix.size
        val columnCount = matrix[0].size
        val n = rowCount * columnCount

        var start = 0
        var end = n

        fun getValueAt(index: Int): Int {
            val row = index / columnCount
            val column = index % columnCount
            return matrix[row][column]
        }

        var mid: Int
        while (start < end) {
            mid = (start + end) / 2
            val value = getValueAt(mid)
            if (target == value) {
                return true
            } else if (target < value) {
                // at left.
                end = mid
            } else {
                start = mid + 1
            }
        }
        return false
    }
}