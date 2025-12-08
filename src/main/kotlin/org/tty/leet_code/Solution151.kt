package org.tty.leet_code

class Solution151 {
    fun reverseWords(s: String): String {
        var wordBuilder = StringBuilder()
        val resultBuilder = StringBuilder()

        for (c in s.reversed()) {
            if (c == ' ' && wordBuilder.isNotEmpty()) {
                if (resultBuilder.isNotEmpty()) {
                    resultBuilder.append(' ')
                }
                resultBuilder.append(wordBuilder.reversed())
                wordBuilder = StringBuilder()
            } else if (c != ' ') {
                wordBuilder.append(c)
            }
        }

        // final.
        if (wordBuilder.isNotEmpty()) {
            if (resultBuilder.isNotEmpty()) {
                resultBuilder.append(' ')
            }
            resultBuilder.append(wordBuilder.reversed())
        }
        return resultBuilder.toString()
    }
}