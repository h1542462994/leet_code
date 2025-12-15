package org.tty.leet_code

class Solution130 {
    fun solve(board: Array<CharArray>): Unit {
        val rowCount = board.size
        val columnCount = board[0].size

        /// 'F': 表示连通外部的
        fun mark(i: Int, j: Int) {
            val cur = board[i][j]

            if (cur == 'O') {
                // 边缘
                if (i == 0 || i == rowCount - 1 || j == 0 || j == columnCount - 1 || board[i - 1][j] == 'F' || board[i + 1][j] == 'F' || board[i][j - 1] == 'F' || board[i][j + 1] == 'F') {
                    board[i][j] = 'F'

                    if (i > 0) {
                        mark(i - 1, j)
                    }
                    if (i < rowCount - 1) {
                        mark(i + 1, j)
                    }
                    if (j > 0) {
                        mark(i, j - 1)
                    }
                    if (j < columnCount - 1) {
                        mark(i, j + 1)
                    }
                }
            }
        }

        for (i in 0 until rowCount) {
            for (j in 0 until columnCount) {
                mark(i, j)
            }
        }

        for (i in 0 until rowCount) {
            for (j in 0 until columnCount) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X'
                } else if (board[i][j] == 'F') {
                    board[i][j] = 'O'
                }
            }
        }

    }
}