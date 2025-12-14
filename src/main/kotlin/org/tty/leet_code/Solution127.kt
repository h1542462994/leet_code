package org.tty.leet_code

class Solution127 {
    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        val wordSet = HashSet<String>(wordList)
        val visitMap = hashMapOf<String, Int>()

        fun generateWords(word: String): List<String> {
            val result = mutableListOf<String>()
            for (i in 0 until word.length) {
                for (s in 'a' .. 'z') {
                    if (s != word[i]) {
                        val newWord = word.replaceRange(i .. i, s.toString())

                        if (wordSet.contains(newWord) && !visitMap.contains(newWord)) {
                            visitMap[newWord] = 1
                            result.add(newWord)
                        }

                    }
                }
            }
            return result
        }

        val list = mutableListOf(beginWord)
        var step = 0
        while (true) {
            val length = list.size

            if (length == 0) {
                return 0
            }

            step++
            for (i in 0 until length) {
                val cur = list.removeFirst()

                if (cur == endWord) {
                    return step
                }

                list.addAll(generateWords(cur))
            }
        }
    }
}