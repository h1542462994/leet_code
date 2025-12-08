package org.tty.leet_code

class Solution45 {
    fun jump(nums: IntArray): Int {
        val counts = Array<Int?>(nums.size) { null }
        counts[0] = 0

        fun update(from: Int, to: Int) {
            if (to >= nums.size) {
                return
            }

            var fromValue = counts[from]
            if (fromValue == null) {
                fromValue = 0
            }

            val toValue = counts[to]
            if (toValue == null || (fromValue + 1 < toValue)) {
                counts[to] = fromValue + 1
            }
        }

        for (i in nums.indices) {
            for (j in i + 1 .. i + nums[i]) {
                update(i, j)

                if (j == nums.size - 1) {
                    return counts[nums.size - 1]!!
                }
            }
        }

        return counts[nums.size - 1]!!
    }
}