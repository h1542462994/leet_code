package org.tty.leet_code

class Solution909 {
    fun snakesAndLadders(board: Array<IntArray>): Int {
        val n = board.size

        val line = IntArray(n * n + 1) { -1 }

        for (i in 0 until n) {
            for (j in 0 until n) {
                if (board[i][j] != -1) {
                    var index = n * (n - i)
                    index -= if ((n - i) % 2 == 0) {
                        j
                    } else {
                        n - j - 1
                    }
                    line[index] = board[i][j]
                }
            }
        }

        val steps = IntArray(n * n + 1) { -1 }
        steps[1] = 0

        val queue = mutableListOf(1)
        var step = 0

        while (true) {

            val length = queue.size
            if (length == 0) {
                return -1
            }

            step++
            for (i in 0 until length) {
                val cur = queue.removeFirst()

                if (n * n - cur <= 6) {
                    return step
                }

                for (j in 1 .. 6) {
                    var target = line[cur + j]
                    if (target == n * n) {
                        return step
                    }

                    if (target == -1) {
                        target = cur + j
                    }

                    if (steps[target] == -1) {
                        steps[target] = step
                        queue.add(target)
                    }
                }
            }
        }


    }
}