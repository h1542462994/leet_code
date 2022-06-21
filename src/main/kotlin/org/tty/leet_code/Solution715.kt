package org.tty.leet_code

import kotlin.math.max
import kotlin.math.min

/**
 * 715:: Range Module
 *
 * A Range Module is a module that tracks ranges of numbers. Design a data structure to track the ranges represented as **half-open intervals** and query about them
 *
 * A **half-open interval** `[left, right)` denotes all the real numbers `x` where `left <= x < right`.
 *
 * Implement the `RangeModule` class:
 * - `RangeModule()` Initializes the object of the data structure.
 * - `void addRange(int left, int right)` Adds the half-open interval [left, right), tracking every real number in that interval. Adding an interval that partially overlaps with currently tracked numbers should add any numbers in the interval [left, right) that are not already tracked.
 * - boolean queryRange(int left, int right) Returns true if every real number in the interval [left, right) is currently being tracked, and false otherwise.
 * - void removeRange(int left, int right) Stops tracking every real number currently being tracked in the half-open interval [left, right).
 *
 * **Solution:**
 * - manage the ordered list dynamically.
 * - when add a range, find the insert place, and remove the covered exist range. (min..max), if the range is already contained, skip it.
 * - when remove a range, compare every range to the provided, then modify , remove or insert the range to maintain the ranges.
 *
 * **Result:**
 * - time: 636ms 71.43%
 * - memory: 63.2MB 57.14%
 * - at 2022/6/21
 *
 * **Optimize:**
 * - the solution use whole iter. it could be optimized by binarySearch to find the start iter point and skip if range is outer range.
 * and you could store it by Chtholly Tree(珂朵莉树)
 *
 */
class RangeModule {

    private data class MRange(
        var start: Int,
        var endExclusive: Int
    )

    override fun toString(): String {
        return if (ranges.isEmpty()) {
            "Empty"
        } else {
            ranges.joinToString(", ") {
                "[${it.start}, ${it.endExclusive})"
            }
        }
    }

    /**
     * ranges, which is no cover and ordered.
     */
    private val ranges = mutableListOf<MRange>()

    /**
     * addRange O(n)
     */
    fun addRange(left: Int, right: Int) {
        if (ranges.isEmpty()) {
            ranges.add(MRange(left, right))
        } else {
            // if range is contained, skip.
            if (queryRange(left, right)) {
                return
            }

            var insertIndex = -1
            var newLeft = left
            var newRight = right
            var i = 0
            while (i < ranges.size) {
                val range = ranges[i]

                // find the probable index to insert.
                if (left < range.start && insertIndex == -1) {
                    val index = (i - 1).coerceAtLeast(0)
                    // if prev visited range is not removed, insert follow it, so add 1.
                    insertIndex = if (index >= 0 && left > ranges[index].endExclusive) {
                        index + 1
                    } else {
                        index
                    }
                }


                // remove covered ranges
                if (range.start in left..right || range.endExclusive in left..right) {
                    // update the range to extend value.
                    newLeft = min(newLeft, range.start)
                    newRight = max(newRight, range.endExclusive)

                    // remove the range
                    ranges.removeAt(i)
                    i--
                }

                i++
            }

            if (insertIndex != -1) {
                ranges.add(insertIndex, MRange(newLeft, newRight))
            } else {
                ranges.add(MRange(newLeft, newRight))
            }
        }
    }

    /**
     * O(log_n)
     */
    fun queryRange(left: Int, right: Int): Boolean {
        if (ranges.isEmpty()) {
            return false
        }

        val searchedIndex = ranges.binarySearch {
           if (left in it.start until it.endExclusive) {
               return@binarySearch 0
           } else if (left > it.endExclusive) {
               return@binarySearch -1
           } else {
               return@binarySearch 1
           }
        }

        return if (searchedIndex !in ranges.indices) {
            false
        } else {
            val range = ranges[searchedIndex]
            left >= range.start && right <= range.endExclusive
        }
    }

    /**
     * O(n)
     */
    fun removeRange(left: Int, right: Int) {
        if (ranges.isEmpty()) {
            return
        }

        var i = 0
        while (i < ranges.size) {
            val range = ranges[i]

            if (range.start in left .. right && range.endExclusive in left .. right) {
                // remove the whole range
                ranges.removeAt(i)
                i--
            } else if (range.endExclusive in left .. right) {
                // shorten the range endExclusive
                range.endExclusive = left
            } else if (range.start in left .. right) {
                // shorten the range start
                range.start = right
            } else if (left in range.start .. range.endExclusive && right in range.start .. range.endExclusive) {
                // remove the range is in a whole range, so you should split it to 2 parts.
                ranges.add(i + 1, MRange(right, range.endExclusive))
                range.endExclusive = left
                i++
            }

            i++
        }
    }

}