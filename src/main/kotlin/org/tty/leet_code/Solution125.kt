package org.tty.leet_code

class Solution125 {
    fun isPalindrome(s: String): Boolean {
        val builder = StringBuilder()

        for (c in s) {
            if (c >= 'A' && c <= 'Z') {
                builder.append(c + ('a' - 'A'))
            } else if (c >= 'a' && c <= 'z') {
                builder.append(c)
            } else if (c >= '0' && c <= '9') {
                builder.append(c)
            }
        }

        val length = builder.length
        for (i in 0 until length / 2) {
            if (builder[i] != builder[length - 1 - i]) {
                return false
            }
        }
        return true
    }
}