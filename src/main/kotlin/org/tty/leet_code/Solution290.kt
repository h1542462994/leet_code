package org.tty.leet_code

class Solution290 {
    fun wordPattern(pattern: String, s: String): Boolean {
        val words = s.split(" ")

        val charToWord = mutableMapOf<Char, String>()
        val wordToChar = mutableMapOf<String, Char>()

        if (pattern.length != words.size) {
            return false
        }

        for (i in pattern.indices) {
            if (charToWord.contains(pattern[i])) {
                if (charToWord[pattern[i]] != words[i]) {
                    return false
                }
            }
            if (wordToChar.contains(words[i])) {
                if (wordToChar[words[i]] != pattern[i]) {
                    return false
                }
            }

            charToWord[pattern[i]] = words[i]
            wordToChar[words[i]] = pattern[i]
        }
        return true
    }
}