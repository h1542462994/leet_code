package org.tty.leet_code

class Solution72 {
    fun minDistance(word1: String, word2: String): Int {
        val n1 = word1.length
        val n2 = word2.length
        val result = Array( n1 + 1) {
            IntArray(n2 + 1) { 0 }
        }

        for (i in 0 .. n1) {
            for (j in 0 .. n2) {
                if (i == 0 || j == 0) {
                    result[i][j] = i + j
                    continue
                }

                if (word1[i - 1] == word2[j - 1]) {
                    result[i][j] = result[i - 1][j - 1]
                } else {
                    result[i][j] = minOf(result[i - 1][j - 1], result[i - 1][j], result[i][j - 1]) + 1
                }
            }
        }
        return result[n1][n2]
    }
}