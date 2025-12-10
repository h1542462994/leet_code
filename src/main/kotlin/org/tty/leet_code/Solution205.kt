package org.tty.leet_code

class Solution205 {
    fun isIsomorphic(s: String, t: String): Boolean {
        val charMap = mutableMapOf<Char, Char>()
        val reversedMap = mutableMapOf<Char, Char>()

        for (c in s.indices) {
            if (charMap.contains(s[c])) {
                if (t[c] != charMap[s[c]]) {
                    return false
                }
            }
            if (reversedMap.contains(t[c])) {
                if (s[c] != reversedMap[t[c]]) {
                    return false
                }
            }

            charMap[s[c]] = t[c]
            reversedMap[t[c]] = s[c]
        }
        return true
    }
}