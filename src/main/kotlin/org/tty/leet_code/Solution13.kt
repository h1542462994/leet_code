package org.tty.leet_code

class Solution13 {
    fun romanToInt(s: String): Int {
        val preMap = mapOf(
            'I' to 1,
            'V' to 5,
            'X' to 10,
            'L' to 50,
            'C' to 100,
            'D' to 500,
            'M' to 1000
        )

        var sum = 0
        for (i in s.indices) {
            sum = if (i == s.length - 1) {
                sum + preMap[s[i]]!!
            } else {
                val cur = preMap[s[i]]!!
                val next = preMap[s[i + 1]]!!
                if (cur < next) {
                    sum - cur
                } else {
                    sum + cur
                }
            }
        }
        return sum
    }
}