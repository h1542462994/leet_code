package org.tty.leet_code

import kotlin.math.max

class Solution56 {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortBy { it -> it.first() }

        var cur: IntArray? = null
        val resultList = mutableListOf<IntArray>()
        for (interval in intervals) {
            if (cur == null) {
                cur = interval
            } else if (interval.first() > cur.last()) {
                resultList.add(cur)
                cur = interval
            } else if (interval.first() <= cur.last()) {
                cur[1] = max(cur[1], interval[1])
            }
        }
        if (cur != null) {
            resultList.add(cur)
        }
        return resultList.toTypedArray()
    }
}