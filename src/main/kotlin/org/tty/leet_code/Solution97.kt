package org.tty.leet_code

class Solution97 {
    fun isInterleave(s1: String, s2: String, s3: String): Boolean {
        val n1 = s1.length
        val n2 = s2.length

        if (n1 + n2 != s3.length) {
            return false
        }

        val table = Array(n1 + 1) {
            BooleanArray(n2 + 1) { true }
        }
        for (i in 0 .. n1) {
            for (j in 0 .. n2) {
                if (i == 0 && j == 0) {
                    continue
                }

                if (j > 0) {
                    // 从(i, j - 1)转移
                    if (s2[j - 1] == s3[i + j - 1] && table[i][j - 1]) {
                        table[i][j] = true
                        continue
                    }
                }

                if (i > 0) {
                    if (s1[i - 1] == s3[i + j - 1] && table[i - 1][j]) {
                        table[i][j] = true
                        continue
                    }
                }
                table[i][j] = false
            }
        }
        return table[n1][n2]
    }
}