package org.tty.leet_code

class Solution191 {
    fun hammingWeight(n: Int): Int {
        var count = 0
        var num = n
        while (num > 0) {
            count += (num and 0x01)
            num = num shr 1
        }
        return count
    }
}