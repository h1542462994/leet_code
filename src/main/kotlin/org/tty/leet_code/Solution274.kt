package org.tty.leet_code

class Solution274 {
    fun hIndex(citations: IntArray): Int {
        citations.sortDescending()

        // 特例
        if (citations[0] <= 0) {
            return 0
        }

        for (i in citations.indices) {
            // 找到第一个不满足的值
            if (citations[i] < i + 1) {
                return i
            }
        }
        return citations.size
    }
}