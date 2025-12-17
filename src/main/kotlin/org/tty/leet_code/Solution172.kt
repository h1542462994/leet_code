package org.tty.leet_code

class Solution172 {
    fun trailingZeroes(n: Int): Int {
        var count = 0
        for (i in 1 .. n) {
            count += compute5(i)
        }
        return count
    }

    fun compute5(n: Int): Int {
        var result = 0
        var num = n
        while (num > 0) {
            if (num % 5 == 0) {
                result += 1
            } else {
                break
            }
            num /= 5
        }
        return result
    }
}