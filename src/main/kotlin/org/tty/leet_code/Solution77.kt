package org.tty.leet_code

import org.tty.leet_code.Solution77.CachedResult

class Solution77 {
    data class SearchKey(
        val a: Int,
        val b: Int,
        val k: Int
    )

    class CachedResult {
        val resultMap = mutableMapOf<SearchKey, List<List<Int>>>()


    }

    fun combine(n: Int, k: Int): List<List<Int>> {
        val cache = CachedResult()
        return bfs(1, n, k, cache)
    }

    fun bfs(a: Int, b: Int, k: Int, cache: CachedResult): List<List<Int>> {
        val searchKey = SearchKey(a, b, k)
        if (cache.resultMap.contains(searchKey)) {
            return cache.resultMap[searchKey]!!
        }


        if (k == 1) {
            val result = (a .. b).map { listOf(it) }
            cache.resultMap[searchKey] = result
            return result
        }

        if (b - a + 1 < k) {
            return listOf()
        } else if (b - a + 1 == k) {
            val result = listOf((a .. b).toList())
            cache.resultMap[searchKey] = result
            return result
        }

        val result = mutableListOf<List<Int>>()

        for (i in a .. b - k + 1) {
            val sub = bfs(i + 1, b, k - 1, cache)

            for (item in sub) {
                val r = mutableListOf(i)
                r.addAll(item)
                result.add(r)
            }
        }

        cache.resultMap[searchKey] = result
        return result
    }
}

class Solution77V2 {
    fun combine(n: Int, k: Int): List<List<Int>> {

        val temp = mutableListOf<Int>()
        val result = mutableListOf<List<Int>>()
        dfs(1, n, k, temp, result)
        return result
    }

    fun dfs(a: Int, b: Int, k: Int, temp: MutableList<Int>, result: MutableList<List<Int>>) {
        if (temp.size + (b - a + 1) < k) {
            return
        } else if (temp.size == k) {
            result.add(temp.toList())
            return
        }

        // if a is included
        temp.add(a)
        dfs(a + 1, b, k, temp, result)
        temp.removeLast()
        dfs(a + 1, b, k, temp, result)
    }
}