package org.tty.leet_code

class Solution70 {
    fun climbStairs(n: Int): Int {
        var a = 1
        var b = 1
        var i = 1
        while (i < n) {

            val t = a + b
            a = b
            b = t
            i++
        }
        return b
    }
}