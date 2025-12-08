package org.tty.leet_code

class Solution36 {
    fun isValid(board: Array<CharArray>, row: IntRange, column: IntRange): Boolean {
        val numSet = mutableSetOf<Char>()

        for (i in row) {
            for (j in column) {
                val c = board[i][j]
                if (c != '.') {
                    if (numSet.contains(c)) {
                        return false
                    }
                    numSet.add(c)
                }
            }
        }
        return true
    }


    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val scanner = 0 until 9
        for (row in scanner) {
            if (!isValid(board, row .. row, scanner)) {
                return false
            }
            if (!isValid(board, scanner, row .. row)) {
                return false
            }
        }

        // scan block
        for (i in 0 until 3) {
            for (j in 0 until 3) {
                if (!isValid(board, 3 * i until 3 * (i + 1), 3 * j until 3 * (j + 1))) {
                    return false
                }
            }
        }
        return true
    }
}