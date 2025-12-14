package org.tty.leet_code

class Solution117 {
    class Node(var `val`: Int) {
        var left: Node? = null
        var right: Node? = null
        var next: Node? = null
    }

    fun connect(root: Node?): Node? {
        if (root == null) {
            return null
        }

        var deque = ArrayDeque<Node>()
        deque.add(root)
        while (deque.isNotEmpty()) {
            val nextDeque = ArrayDeque<Node>()

            while (deque.isNotEmpty()) {
                val top = deque.removeFirst()
                top.next = deque.firstOrNull()
                if (top.left != null) {
                    nextDeque.add(top.left!!)
                }
                if (top.right != null) {
                    nextDeque.add(top.right!!)
                }
            }
            deque = nextDeque
        }
        return root
    }
}