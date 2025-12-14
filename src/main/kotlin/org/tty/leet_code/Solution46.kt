package org.tty.leet_code

class Solution46 {
    fun permute(nums: IntArray): List<List<Int>> {
        val source = nums.toMutableList()
        val temp = mutableListOf<Int>()

        val result = mutableListOf<List<Int>>()

        bfs(source, temp, result)
        return result
    }

    fun bfs(nums: MutableList<Int>, temp: MutableList<Int>, result: MutableList<List<Int>>) {
        if (nums.isEmpty()) {
            return
        }
        if (nums.size == 1) {
            temp.add(nums[0])
            result.add(temp.toList())
            temp.removeLast()
            return
        }

        // 回溯
        val length = nums.size
        for (i in 0 until length) {
            val cur = nums.removeAt(i)
            temp.add(cur)
            bfs(nums, temp, result)
            nums.add(i, cur)
            temp.removeLast()
        }


    }
}