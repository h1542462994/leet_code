package org.tty.leet_code

class Solution221 {
    fun maximalSquare(matrix: Array<CharArray>): Int {
        val rowCount = matrix.size
        val columnCount = matrix[0].size

        val table = Array(rowCount) {
            IntArray(columnCount) { 0 }
        }

        var flag = false
        for (i in 0 until rowCount) {
            for (j in 0 until columnCount) {
                if (matrix[i][j] == '1') {
                    flag = true
                    table[i][j] = 1
                }
            }
        }

        // 根本没有1
        if (!flag) {
            return 0
        }

        // 原地修改
        var N = 2
        var result = 1

        var find = true
        while (find && N <= rowCount && N <= columnCount) {
            find = false

            for (i in 0 until rowCount - N + 1) {
                for (j in 0 until columnCount - N + 1) {
                    // 判断以i,j为左上角的点是否构成正方形
                    if (matrix[i][j] == '1' && table[i + 1][j + 1] == 1) {
                        // 判断中间的长方形是否均为1
                        var flag = true
                        for (j2 in j + 1 until j + N) {
                            if (matrix[i][j2] == '0') {
                                flag = false
                                break
                            }
                        }
                        if (flag) {
                            for (i2 in i + 1 until i + N) {
                                if (matrix[i2][j] == '0') {
                                    flag = false
                                    break
                                }
                            }
                        }
                        if (flag) {
                            table[i][j] = 1
                            find = true
                            continue
                        }
                    }
                    table[i][j] = 0
                }
            }
            if (find) {
                result = N * N
                N++
            }
        }
        return result
    }
}