package org.tty.leet_code

class Solution399 {
    class Env(
        val hashGraph: MutableMap<String, MutableMap<String, Double>>,
        val visited: MutableMap<String, Unit> = mutableMapOf()
    )

    fun calcEquation(equations: List<List<String>>, values: DoubleArray, queries: List<List<String>>): DoubleArray {
        val hashGraph = mutableMapOf<String, MutableMap<String, Double>>()

        check(equations.size == values.size)

        fun putItem(item: List<String>, value: Double) {
            if (!hashGraph.containsKey(item[0])) {
                hashGraph[item[0]] = mutableMapOf()
            }
            if (!hashGraph.containsKey(item[1])) {
                hashGraph[item[1]] = mutableMapOf()
            }

            hashGraph[item[0]]!![item[1]] = value
            hashGraph[item[1]]!![item[0]] = 1 / value
        }

        for (i in equations.indices) {
            val item = equations[i]
            val value = values[i]

            putItem(item, value)
        }


        val result = DoubleArray(queries.size)
        var index = 0
        for (query in queries) {
            if (!hashGraph.containsKey(query[0]) || !hashGraph.containsKey(query[1])) {
                result[index++] = -1.0
                continue
            }

            val env = Env(hashGraph)
            val r = searchResult(query[0], query[1], 1.0,  env)

            if (r == null) {
                result[index++] = -1.0
            } else {
                result[index++] = r
            }
        }

        return result
    }

    fun searchResult(from: String, to: String, cur: Double, env: Env): Double? {
        env.visited[from] = Unit
        val targets = env.hashGraph[from]!!

        if (targets.contains(to)) {
            return cur * targets[to]!!
        }

        for (t in targets) {
            // 未搜索的路径
            if (env.visited[t.key] == null) {
                val cur = searchResult(t.key, to, cur * t.value, env)
                if (cur != null) {
                    return cur
                }
            }
        }
        return null
    }
}