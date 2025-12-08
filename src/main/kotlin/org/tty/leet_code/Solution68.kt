package org.tty.leet_code

class Solution68 {
    class FindResult(
        var sum: Int,
        var words: Array<String>,
        var end: Boolean
    )

    fun fullJustify(words: Array<String>, maxWidth: Int): List<String> {
        var index = 0

        fun select(): FindResult {
            var sum = -1
            val startIndex = index
            while(sum < maxWidth && index < words.size) {
                val curLength = words[index].length
                if (sum + 1 + curLength > maxWidth) {
                    return FindResult(sum, words.sliceArray(startIndex until index), false)
                } else {
                    sum += 1 + curLength
                    index++
                }
            }

            return FindResult(sum, words.sliceArray(startIndex until index), true)
        }

        val resultList = mutableListOf<String>()
        while (index < words.size) {
            val result = select()

            val builder = StringBuilder()

            if (result.words.size == 1 || result.end) {
                // left print.
                for (word in result.words) {
                    if (builder.isNotEmpty()) {
                        builder.append(' ')
                    }
                    builder.append(word)
                }
                builder.append(" ".repeat(maxWidth - builder.length))
            } else {
                // center print.
                val remainCount = maxWidth - result.sum
                val each = remainCount / (result.words.size - 1)
                val offset = remainCount % (result.words.size - 1)
                for (i in result.words.indices) {
                    if (builder.isNotEmpty()) {
                        if (i <= offset) {
                            builder.append(" ".repeat(2 + each))
                        } else {
                            builder.append(" ".repeat( 1 + each))
                        }
                    }
                    builder.append(result.words[i])
                }
            }
            resultList.add(builder.toString())
        }
        return resultList
    }
}