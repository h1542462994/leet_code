package org.tty.leet_code

class Solution58 {
    fun lengthOfLastWord(s: String): Int {
        var result = 0
        for (i in s.indices.reversed()) {
            if (s[i] == ' ' && result != 0) {
                return result
            } else if (s[i] != ' ') {
                result += 1
            }
        }
        return result
    }
}