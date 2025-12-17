package org.tty.leet_code

class Solution66 {
    fun plusOne(digits: IntArray): IntArray {
        val result = mutableListOf<Int>()

        var overflow = 0
        for (i in (0 until digits.size).reversed()) {
            val value = if (i == digits.size - 1) {
                digits[i] + 1
            } else {
                digits[i] + overflow
            }

            result.add(0, value % 10)
            overflow = value / 10
        }
        if (overflow > 0) {
            result.add(0, overflow)
        }

        return result.toIntArray()
    }
}