package org.tty.leet_code


/**
 * 566:: Next Greater Element III
 *
 * Given a positive integer n, find the smallest integer which has exactly the same digits existing in the integer n and is greater in value than n. If no such positive integer exists, return -1.
 *
 * Note that the returned integer should fit in 32-bit integer, if there is a valid answer but it does not fit in 32-bit integer, return -1.
 *
 * **Solution:**
 * 1. from i:= arr.size - 2 down 0, find the first element which matches `arr[i] < arr[i + 1]` (break point), mark as t.
 * means the element at t should be replaced with another element, result at n' > n
 * 2. from i:= arr.size - 1 down to t + 1, find the first element matches `arr[i] > t`, means the minimum element can be replaced. mark as k
 * 3. swap arr's element at t, k, and reverse arr's element from t + 1 until arr.size
 * 4. check the intRange
 *
 * **Result:**
 * - time 140ms 100.00%
 * - memory 32.6MB 66.67
 * - at 2022/7/4
 */
class Solution556 {
    private fun intToBits(n: Int): MutableList<Int> {
        val result = mutableListOf<Int>()
        var value = n
        while (value > 0) {
            val bit = value % 10
            result.add(0, bit)
            value /= 10
        }
        return result
    }

    private fun bitsToInt(bits: List<Int>): Int {
        var result = 0L
        bits.forEach {
            result = result * 10 + it
        }
        return if (result > Int.MAX_VALUE) {
            -1
        } else {
            result.toInt()
        }
    }

    private fun swap(arr: MutableList<Int>, i: Int, j: Int) {
        val t = arr[i]
        arr[i] = arr[j]
        arr[j] = t
    }

    private fun findMinRelateTo(bits: List<Int>, relate: Int): Int {
        for (i in bits.size - 1 downTo  0) {
            if (bits[i] > relate) {
                return i
            }
        }
        return 0
    }

    fun nextGreaterElement(n: Int): Int {
        val bits = intToBits(n)
        for (i in bits.size - 2 downTo  0) {
            if (bits[i] < bits[i + 1]) {
                val subBits = bits.subList(i + 1, bits.size)
                val index = findMinRelateTo(subBits, bits[i])
                swap(bits, i, i + 1 + index)
                bits.subList(i + 1, bits.size).reverse()
                break
            }
        }

        val result = bitsToInt(bits)
        return if (result == n) {
            -1
        } else {
            result
        }
    }
}