package org.tty.leet_code

import kotlin.math.max

class Solution128 {

    class Counter(var value: Int = 1, var counter: Counter? = null)  {
        var count: Int
            get() {
                return if (counter == null) {
                    value
                } else {
                    counter!!.count
                }
            }
            set(value) {
                if (counter == null) {
                    this.value = value
                } else {
                    counter!!.count = value
                }
            }
    }

    fun longestConsecutive(nums: IntArray): Int {
        val numHash = mutableMapOf<Int, Counter>()

        var value = 0
        for (num in nums) {
            val left = numHash[num - 1]
            val right = numHash[num + 1]

            if (numHash[num] != null) {
                continue
            }

            if (left == null && right == null) {
                numHash[num] = Counter()
                value = max(value, 1)
            } else if (left == null && right != null) { // right != null
                numHash[num] = right
                right.count += 1
                value = max(value, right.count)
            } else if (left != null && right == null) {
                numHash[num] = left
                left.count += 1
                value = max(value, left.count)
            } else if (left != null && right != null) {
                val sum = left.count + right.count + 1
                left.count = sum
                // right 被丢弃
                right.counter = left
                numHash[num] = left
                value = max(value, sum)
            }
        }
        return value
    }
}