package org.tty.leet_code

class Solution12 {
    fun intToRoman(num: Int): String {
        val preList = listOf(
            listOf('I', 'V'),
            listOf('X', 'L'),
            listOf('C', 'D'),
            listOf('M')
        )

        var value = num
        var str = ""
        var index = 0
        while (value > 0) {
            val digit = value % 10
            value = value / 10

            val builder = StringBuilder()
            if (digit <= 3) {
                repeat(digit) {
                    builder.append(preList[index][0])
                }
            } else if (digit == 4) {
                builder.append(preList[index][0]).append(preList[index][1])
            } else if (digit <= 8) {
                builder.append(preList[index][1])
                repeat(digit - 5) {
                    builder.append(preList[index][0])
                }
            } else {
                builder.append(preList[index][0]).append(preList[index + 1][0])
            }
            str = builder.toString() + str

            index++
        }
        return str
    }
}