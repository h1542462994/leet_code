package org.tty.leet_code

import kotlin.math.max

class Solution67 {
    fun addBinary(a: String, b: String): String {
        val pa = a.reversed()
        val pb = b.reversed()

        val sb = StringBuilder()
        var overflow = 0
        for (i in 0 until max(pa.length, pb.length)) {
            val left = if (i < pa.length) (pa[i] - '0') else 0
            val right = if (i < pb.length) (pb[i] - '0') else 0
            val result = left + right + overflow

            sb.append('0' + result % 2)
            overflow = result / 2
        }

        if (overflow > 0) {
            sb.append('1')
        }

        return sb.reversed().toString()
    }
}