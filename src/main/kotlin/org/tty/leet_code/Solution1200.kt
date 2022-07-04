package org.tty.leet_code

/**
 * 1200::Minimum Absolute Difference.
 *
 * Given an array of distinct integers arr, find all pairs of elements with the minimum absolute difference of any two elements.
 * Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows
 * - `a, b` are from `arr`
 * - `a < b`
 * - `b - a` equals to the minimum absolute difference of any two elements in arr
 *
 * **Solution:**
 * 1. sort the array
 * 2. first iter to calculate the minGap
 * 3. second iter to get the result list
 *
 * **Result**
 * - time: 424ms 100%
 * - memory: 54.4MB 33.33%
 * - at 2022/7/4
 */
class Solution1200 {
    private fun minValue(left: Int, right: Int): Int {
        return if (left <= right) {
            left
        } else {
            right
        }
    }

    fun minimumAbsDifference(arr: IntArray): List<List<Int>> {
        arr.sort()
        var minGap = Int.MAX_VALUE
        val resultList = mutableListOf<List<Int>>()
        for (i in 1 until arr.size) {
            val diff = arr[i] - arr[i - 1]
            minGap = minValue(minGap, diff)
        }
        for (i in 1 until arr.size) {
            val diff = arr[i] - arr[i - 1]
            if (diff == minGap) {
                resultList.add(listOf(arr[i - 1], arr[i]))
            }
        }

        return resultList
    }
}