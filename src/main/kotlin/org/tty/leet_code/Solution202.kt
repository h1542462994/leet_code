package org.tty.leet_code

class Solution202 {
    fun isHappy(n: Int): Boolean {
        fun transform(n: Int): Int {
            var sum = 0
            var num = n
            while (num > 0) {
                sum += (num % 10) * (num % 10)
                num /= 10
            }
            return sum
        }

        val dict = mutableMapOf<Int, Unit>()
        var num = n
        while (true) {
            if (num == 1) {
                return true
            } else if (dict.contains(num)) {
                return false
            }
            dict[num] = Unit
            num = transform(num)
        }
    }
}