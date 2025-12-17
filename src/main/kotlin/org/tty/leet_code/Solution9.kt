package org.tty.leet_code

class Solution9 {
    fun isPalindrome(x: Int): Boolean {
        if (x < 0) {
            return false
        } else if (x == 0) {
            return true
        }

        val numbers = mutableListOf<Int>()
        var num = x
        while (num > 0) {
            numbers.add(num % 10)
            num /= 10
        }

        for (i in 0 until numbers.size / 2) {
            if (numbers[i] != numbers[numbers.size - 1 - i]) {
                return false
            }
        }
        return true
    }
}