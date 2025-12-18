package org.tty.leet_code

class Solution5 {
    fun longestPalindrome(s: String): String {
        val n = s.length
        val paliMark = Array(n) {
            BooleanArray(n - it) { true }
        }

        var result: String = s.substring(0, 1)

        var prevFind = true

        var i = 1
        while (i < n) {
            var find = false

            for (j in 0 until n - i) {
                var superIs = true
                if (i > 1) {
                    superIs = paliMark[i - 2][j + 1]
                }

                if (superIs && (s[j] == s[j + i])) { // is!
                    paliMark[i][j] = true
                    if (!find) {
                        find = true
                        result = s.substring(j, j + i + 1)
                    }
                } else {
                    paliMark[i][j] = false
                }


            }
            if (!find && !prevFind) { // 连续两排没有，直接中止
                break
            }
            prevFind = find
            i++
        }

        return result

    }
}