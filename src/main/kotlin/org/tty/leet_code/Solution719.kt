package org.tty.leet_code

/**
 * 719:: Find K-th Smallest Pair Distance (Normal)
 *
 * The **distance of a pair** of integers `a` and `b` is defined as the absolute difference between a and b.
 * Given an integer array `nums` and an integer `k`, return the `k^th` smallest distance among all the pairs `nums[i]` and `num[j]` where `0 <= i < j < nums.length`
 *
 *
 * **Constraints**
 * - n == nums.length
 * - 2 <= n <= 10^4
 * - 0 <= nums[i] <= 10^6
 * - 1 <= k <= n * (n - 1) / 2
 *
 * **Result**
 * - TLE
 * - at: 2022/6/16
 */
class Solution719V1 {
    private val storage = hashMapOf<Int, Int>()

    private fun List<Int>.countOfDistance(value: Int): Int {
        var result = storage[value]
        return if (result != null) {
            result
        } else {
            val map = hashMapOf<Int, Int>()
            result = 0
            for (element in this) {
                // calculate if the (element - value) is in hashtable, add count.
                result += map.getOrDefault(element - value, 0)
                // mark the element to the hashtable
                val count = map.getOrDefault(element, 0)
                map[element] = count + 1
            }
            storage[value] = result
            result
        }
    }

    private fun List<Int>.binarySearch(
        start: Int,
        endExclusive: Int, // search range
        targetIndex: Int,
        fromIndex: Int, // search index
        receiver: (Int) -> Unit // receiver function.
    ): Int {
        return if (endExclusive == start) {
            0
        } else if (endExclusive - start == 1) {
            val count = countOfDistance(start)
            if (targetIndex in fromIndex until  fromIndex + count) {
                // when found, call receive function
                receiver(start)
            }
            count
        } else {
            val mid = (start + endExclusive) / 2
            val count = binarySearch(start, mid, targetIndex, fromIndex, receiver)
            // cut branch.
            if (targetIndex in fromIndex until  fromIndex + count) {
                count
            } else {
                count + binarySearch(mid, endExclusive, targetIndex, fromIndex + count, receiver)
            }
        }
    }

    fun smallestDistancePair(nums: IntArray, k: Int): Int {
        // sort the numList
        val numList = nums.toList().sorted()
        val n = numList.size
        val endExclusive = (numList[n - 1] - numList[0]) + 1
        val start = 0
        var result = 0
        numList.binarySearch(start, endExclusive, k - 1, 0) {
            result = it
        }
        return result
    }
}


/**
 * **Solution**
 *
 * Keyword: Binary Search
 *
 * **Notice: countInDistance is a O(num) function**, upper solution is calculate distance == n, otherwise <= n, so it occurs TLE.
 *
 * 1. define a function countInDistance, which is the justice of the binarySearch
 * 2. use binary Search, which range is in min .. max, justice is countInDistance, result is distance.
 *
 * The difficulty is the bound justice and the analysis of the justice function.
 *
 * **Result**
 * - time: 284ms 60.00%
 * - memory: 38.6MB **20.00%**
 * - at: 2022/6/16
 *
 * in my solution, I will define some functions and extra containers, so memory performance would be not fine enough.
 */
class Solution719V2 {
    /**
     * calculate count in [distance], double pointer function.
     *
     * O(num)
     */
    private fun List<Int>.countInDistance(distance: Int): Int {
        var left = 0
        var count = 0
        this.forEachIndexed { index, v ->
            while (v - this[left] > distance) {
                left++
            }
            count += index - left
        }
        return count
    }

    /**
     * binary search
     *
     * O(num * log_n)
     */
    private tailrec fun List<Int>.binarySearch(start: Int, endInclusive: Int, targetIndex: Int): Int {
        return if (start == endInclusive) {
            start
        } else {
            val mid = (start + endInclusive) / 2
            val count = countInDistance(mid)
            if (targetIndex < count) {
                binarySearch(start, mid, targetIndex)
            } else {
                binarySearch(mid + 1, endInclusive, targetIndex)
            }
        }
    }


    /**
     * minDistance
     *
     * O(num)
     */
    private fun List<Int>.minDistance(): Int {
        var minValue = this[1] - this[0]
        for (i in 2 until this.size) {
            val v = this[i] - this[i - 1]
            if (v < minValue) {
                minValue = v
            }
        }
        return minValue
    }

    fun smallestDistancePair(nums: IntArray, k: Int): Int {
        // sort the numList
        val numList = nums.toList().sorted()
        val n = numList.size
        val endInclusive = (numList[n - 1] - numList[0])
        val start = numList.minDistance()
        return numList.binarySearch(start, endInclusive, k - 1)
    }
}