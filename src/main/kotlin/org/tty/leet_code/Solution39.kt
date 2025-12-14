package org.tty.leet_code

class Solution39 {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val temp = mutableListOf<Int>()
        val result = mutableListOf<List<Int>>()

        dfs(candidates, 0, target, temp, result)
        return result
    }

    fun dfs(candidates: IntArray, index: Int, target: Int, temp: MutableList<Int>, result: MutableList<List<Int>>) {
        if (temp.sum() == target) {
            result.add(temp.toList())
            return
        } else if (temp.sum() > target) {
            return
        }

        for (i in index until candidates.size) {
            val v = candidates[i]
            temp.add(v)
            dfs(candidates,  i, target, temp, result)
            temp.removeLast()
        }
    }
}