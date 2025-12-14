package org.tty.leet_code

class Solution207 {


    /**
     * 判断图是否成环
     */
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val states = IntArray(numCourses) { 0 }
        val paths = mutableMapOf<Int, MutableList<Int>>()

        for (item in prerequisites) {
            states[item[1]] += 1

            if (!paths.containsKey(item[0])) {
                paths[item[0]] = mutableListOf()
            }

            paths[item[0]]!!.add(item[1])
        }

        var modified = true
        while (modified) {
            modified = false

            for (i in 0 until numCourses) {
                if (states[i] != 0) {
                    continue
                }

                val path = paths[i]
                if (path != null) {
                    for (l in path) {
                        states[l]--
                        modified = true
                    }
                    path.clear()
                }
            }
        }

        return states.all { it == 0 }
    }
}