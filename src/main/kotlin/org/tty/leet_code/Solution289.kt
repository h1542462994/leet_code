package org.tty.leet_code

class Solution289 {
    fun gameOfLife(board: Array<IntArray>): Unit {
        val rowCount = board.size
        val columnCount = board[0].size

        fun update(i: Int, j: Int): Unit {
            var sum = 0
            for (a in (i - 1).coerceIn(0 until rowCount) .. (i + 1).coerceIn(0 until rowCount)) {
                for (b in (j - 1).coerceIn(0 until columnCount) .. (j + 1).coerceIn(0 until columnCount)) {
                    if (a == i && b == j) {
                        continue
                    }
                    val cur = board[a][b] and 1
                    sum += cur
                }
            }

            var cur = board[i][j] and 1
            if (cur == 1) {
                cur += if (sum in 2..3) {
                    2
                } else {
                    0
                }
            } else if (sum == 3) {
                cur += 2
            }
            board[i][j] = cur
        }

        for (i in 0 until rowCount) {
            for (j in 0 until columnCount) {
                update(i, j)
            }
        }

        for (i in 0 until rowCount) {
            for (j in 0 until columnCount) {
                board[i][j] = board[i][j] shr 1
            }
        }
    }
}