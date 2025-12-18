package org.tty.leet_code

class Solution50 {
    fun myPow(x: Double, n: Int): Double {
        if (n == 0) {
            return 1.0
        }

        var base = x
        var exp: Long = n.toLong()

        if (n < 0) {
            base = 1 / x
            exp = -exp
        }

        var result = 1.0
        // get bits until 1.
        while (exp > 1) {
            if (exp and 1L == 1L) {
                result *= base
            }
            base *= base
            exp = exp shr 1
        }

        return result
    }
}