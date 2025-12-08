package org.tty.leet_code

import kotlin.math.max

class Solution3 {
    fun lengthOfLongestSubstring(s: String): Int {
        if (s.isEmpty()) {
            return 0
        }

        var i = 0
        var j = 1
        var str = s.substring(i, j)
        var maxLength = 1

        while (j < s.length) {
            if (!str.contains(s[j])) {
                str += s[j]
                maxLength = max(maxLength, j - i + 1)
            } else {
                i += str.indexOf(s[j]) + 1
                str = s.substring(i, j + 1)
            }
            j++
        }
        return maxLength
    }
}