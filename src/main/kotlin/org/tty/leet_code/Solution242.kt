package org.tty.leet_code

class Solution242 {
    fun isAnagram(s: String, t: String): Boolean {
        val charCounts = mutableMapOf<Char, Int>()
        if (s.length != t.length) {
            return false
        }

        for (char in s) {
            charCounts[char] = (charCounts[char] ?: 0) + 1
        }
        for (char in t) {
            charCounts[char] = (charCounts[char] ?: 0) - 1
        }

        for (pair in charCounts) {
            if (pair.value != 0) {
                return false
            }
        }
        return true
    }



}