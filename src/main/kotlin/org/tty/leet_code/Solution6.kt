package org.tty.leet_code

class Solution6 {
    fun convert(s: String, numRows: Int): String {
        if (numRows == 1) {
            return s
        }

        val everyGroup = 2 * (numRows - 1)
        val groups = (s.length - 1) / everyGroup + 1

        fun get(group: Int, offset: Int): String {
            val index = everyGroup * group + offset
            return if (index >= s.length) {
                ""
            } else {
                s[index].toString()
            }
        }

        val resultBuilder = StringBuilder()
        for (j in 0 .. everyGroup / 2) {
            for (i in 0 until groups) {
                resultBuilder.append(get(i, j))
                if (j > 0 && j < everyGroup / 2) {
                    resultBuilder.append(get(i, everyGroup - j))
                }
            }
        }
        return resultBuilder.toString()
    }
}