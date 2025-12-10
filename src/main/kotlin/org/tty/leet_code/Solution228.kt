package org.tty.leet_code

class Solution228 {
    class Range(
        val start: Int,
        var end: Int
    ) {
        override fun toString(): String {
            return if (start == end) {
                start.toString()
            } else {
                "$start->$end"
            }
        }
    }

    fun summaryRanges(nums: IntArray): List<String> {
        var range: Range? = null

        val result = mutableListOf<String>()

        for (num in nums) {
            if (range == null) {
                range = Range(num, num)
            } else if (num == range.end + 1) {
                range.end = num
            } else {
                result.add(range.toString())
                range = Range(num, num)
            }
        }
        if (range != null) {
            result.add(range.toString())
        }


        return result
    }
}