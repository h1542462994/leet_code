package org.tty.leet_code

class Solution14 {
    fun longestCommonPrefix(strs: Array<String>): String {
        var minLength: Int? = null
        for (s in strs) {
            if (minLength == null || s.length < minLength) {
                minLength = s.length
            }
        }
        if (minLength == null) {
            return ""
        }
        val prefixBuilder = StringBuilder()
        for (i in 0 until minLength) {
            val c = strs[0][i]
            for (j in 1 until strs.size) {
                if (strs[j][i] != c) {
                    return prefixBuilder.toString()
                }
            }
            prefixBuilder.append(c)
        }
        return prefixBuilder.toString()
    }
}