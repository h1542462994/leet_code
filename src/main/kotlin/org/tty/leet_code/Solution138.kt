package org.tty.leet_code

class Solution138 {
    class Node(var `val`: Int) {
        var next: Node? = null
        var random: Node? = null
    }

    fun copyRandomList(node: Node?): Node? {
        // use next to create a LinkedList.
        // and cache the map from source to new.

        var headNode: Node? = null
        var curNode: Node? = null

        val nodeMap = mutableMapOf<Node, Node>()

        // copy node.
        var p = node
        while (p != null) {
            val createNode = Node(p.`val`)
            createNode.next = p.next

            if (headNode == null) {
                headNode = createNode
            } else {
                curNode?.next = createNode
            }
            curNode = createNode
            nodeMap[p] = createNode
            p = p.next
        }

        for (nodePair in nodeMap) {
            val source = nodePair.key
            val target = nodePair.value

            val sourceRandom = source.random
            if (sourceRandom != null) {
                target.random = nodeMap[sourceRandom]
            }
        }
        return headNode
    }
}