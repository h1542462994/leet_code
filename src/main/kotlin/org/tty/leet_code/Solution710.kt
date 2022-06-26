package org.tty.leet_code

import kotlin.random.Random

/**
 * 710:: Random Pick with Blacklist
 *
 * You are given an integer `n` and an array of **unique** integers `blacklist`.
 * Design an algorithm to pick a random integer in thr range `[0, n - 1]` that is **not** in `blacklist`.
 * Any integer that is the mentioned range and not in `blacklist` should be **equally likely** to be returned.
 *
 * Optimize you algorithm such that is minimizes the number of calls to the **built-in** random function of your language.
 *
 * **Solution:**
 *
 * prepared with rangeMap
 *
 * - 1. by n and blackList, construct a number map (from provided random number to result), and use range to save the storage.
 * - 2. when query, use binary search
 *
 * let u = blackList.size, t = n - blackList.size, r = ranges.size
 *
 * - time complexity: O(u) in initializing, O(log_r) in search
 * - space complexity: O(1) ~ O(n - blackList.size)
 *
 * **Result:**
 * - time: 652ms 100%
 * - memory: 63.5MB 100%
 * - at 2022/6/26
 */
class Solution710(n: Int, blackList: IntArray) {

    data class Range(
        val start:Int,
        val endExclusive: Int,
        val offset: Int)

    private var realN = 0
    private val ranges = mutableListOf<Range>()

    init {
        initialize(n, blackList)
    }

    private fun initialize(n: Int, blackList: IntArray) {
        realN = n - blackList.size

        // create a iterator
        val iterator = iterator {
            blackList.sort()
            blackList.forEach { yield(it) }
            yield(n) // use n to calculate the last value.
        }

        // prevLeft, initialize as 0 (target)
        var prevLeft = 0
        // totalOffset
        var totalOffset = 0
        // prevScan value (source)
        var prevScan = -1

        for (number in iterator) {
            if (number != prevScan + 1) { // not continuous, to create a range
                // length
                val length = number - prevScan - 1
                ranges.add(Range(prevLeft,  prevLeft + length, totalOffset))
                // nextLeft is offset by length
                prevLeft += length
            }

            totalOffset += 1
            prevScan = number
        }
    }


    fun pick(): Int {
        val randomSource = Random.nextInt(realN)
//        println(randomSource)
//        println(ranges)
        val index = ranges.binarySearch {
            if (randomSource >= it.start && randomSource < it.endExclusive) {
                0
            } else if (randomSource >= it.endExclusive) {
                -1
            } else {
                1
            }
        }
        return randomSource + ranges[index].offset
    }
}