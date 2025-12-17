package org.tty.leet_code

class Solution190 {
    fun reverseBits(n: Int): Int {
        var result = 0
        var num = n
        val bitMask = 0x01

        for (i in 0 until 32) {
            val bit = num and bitMask
            num = num shr 1
            result = (result shl 1) or bit
        }
        return result
    }


}