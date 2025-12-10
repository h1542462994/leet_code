package org.tty.leet_code

import kotlin.math.max
import kotlin.math.min

class Solution57 {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val resultList = mutableListOf<IntArray>()

        var curInterval: IntArray? = newInterval
        for (interval in intervals) {
            if (curInterval == null) {
                resultList.add(interval)
                continue
            }

            if (interval[1] < newInterval[0]) {
                resultList.add(interval)
            } else if (interval[0] > newInterval[1]) {
                resultList.add(curInterval)
                curInterval = null
                resultList.add(interval)
            } else {
                curInterval = intArrayOf(min(curInterval[0], interval[0]), max(curInterval[1], interval[1]))
            }
        }

        if (curInterval != null) {
            resultList.add(curInterval)
        }

        return resultList.toTypedArray()
    }
}