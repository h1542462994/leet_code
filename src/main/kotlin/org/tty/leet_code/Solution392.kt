package org.tty.leet_code

class Solution392 {
    fun isSubSequence(s: String, t: String): Boolean {
        // build indexHashes
        val charIndexes = mutableMapOf<Char, MutableList<Int>>()

        for (i in t.indices) {
            charIndexes.putIfAbsent(t[i], mutableListOf())
            charIndexes[t[i]]!!.add(i)
        }

        var maxIndex = -1
        for (c in s) {
            val list = charIndexes[c] ?: return false
            val nextIndex = list.firstOrNull { it > maxIndex }

            if (nextIndex == null) {
                return false
            }
            maxIndex = nextIndex
        }
        return true
    }
}