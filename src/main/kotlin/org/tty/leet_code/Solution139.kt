package org.tty.leet_code

class Solution139 {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val wordSet = mutableSetOf<String>()
        wordSet.addAll(wordDict)

        val canBuildWords = BooleanArray(s.length + 1) { false }
        canBuildWords[0] = true

        for (n in 1 .. s.length) {
            for (p in 0 until n) {
                if (canBuildWords[p]) {
                    val cur = s.substring(p until n)
                    if (wordSet.contains(cur)) {
                        canBuildWords[n] = true
                        break
                    }
                }
            }
        }
        return canBuildWords[s.length]
    }
}