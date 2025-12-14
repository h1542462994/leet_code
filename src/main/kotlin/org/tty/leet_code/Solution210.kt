package org.tty.leet_code

class Solution210 {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val states = IntArray(numCourses) { 0 }
        val paths = mutableMapOf<Int, MutableList<Int>>()

        for (item in prerequisites) {
            states[item[1]] += 1

            if (!paths.containsKey(item[0])) {
                paths[item[0]] = mutableListOf()
            }

            paths[item[0]]!!.add(item[1])
        }

        val resultList = mutableListOf<Int>()

        var modified = true
        while (modified) {
            modified = false

            for (i in 0 until numCourses) {
                if (!resultList.contains(i) && states[i] == 0) {
                    resultList.add(i)
                    modified = true
                    val target = paths[i]
                    target?.forEach { states[it] -= 1 }
                }
            }
        }

        return if (resultList.size == numCourses) {
            resultList.reversed().toIntArray()
        } else {
            IntArray(0)
        }
    }
}