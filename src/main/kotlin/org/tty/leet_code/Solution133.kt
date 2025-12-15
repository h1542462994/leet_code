package org.tty.leet_code

class Solution133 {
    class Node(var `val`: Int) {
        var neighbors: ArrayList<Node?> = ArrayList<Node?>()
    }

    class Cache(
        val nodeMap: MutableMap<Node, Node> = mutableMapOf()
    )

    fun cloneGraph(node: Node?): Node? {
        if (node == null) {
            return null
        }

        val cache = Cache()
        // 先创建节点
        createNode(node, cache)

        // 然后添加所有链
        for (pair in cache.nodeMap) {
            val source = pair.key
            val target = pair.value

            source.neighbors.forEach {
                if (it != null) {
                    target.neighbors.add(cache.nodeMap[it])
                }
            }
        }
        return cache.nodeMap[node]
    }

    fun createNode(node: Node, cache: Cache) {
        if (cache.nodeMap.contains(node)) {
            return
        }

        val newNode = Node(node.`val`)
        cache.nodeMap[node] = newNode
        node.neighbors.forEach {
            if (it != null) {
                createNode(it, cache)
            }
        }
    }
}