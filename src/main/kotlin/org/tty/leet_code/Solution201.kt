package org.tty.leet_code

class Solution201 {
    fun rangeBitwiseAnd(left: Int, right: Int): Int {
        var n = right

        while (left < n) {
            n = n and (n - 1)
        }
        return n
    }
}