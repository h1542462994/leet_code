package org.tty.leet_code.test

import org.tty.leet_code.Node
import org.tty.leet_code.TreeNode

object Interact {
    fun readIntArray(value: String): IntArray {
        val length = value.length
        return value
            .slice(1 until length - 1)
            .split(",")
            .map { it.toInt() }
            .toIntArray()
    }

    fun writeIntArray(value: IntArray): String {
        return "[${value.joinToString(", ")}]"
    }

    fun createTree(values: List<Int?>): TreeNode? {
        var root: TreeNode? = null
        val deque = ArrayDeque<TreeNode>()

        values.forEachIndexed { index, v ->
            val node = if (v == null) { null } else { TreeNode(v) }

            if (node != null) {
                // note first element
                if (index > 0) {
                    if (index % 2 == 1) {
                        deque.first().left = node
                    } else {
                        deque.first().right = node
                    }
                } else {
                    root = node
                }
                deque.addLast(node)
            }

            if (index > 0 && index % 2 == 0) {
                deque.removeFirst()
            }
        }

        return root
    }

    /**
     * fast to create a testcase.
     */
    fun createCircleLinkedListNode(input: List<Int>): Node? {
        if (input.isEmpty()) {
            return null
        } else {
            var head: Node? = null
            var cur: Node? = null
            input.forEach {
                val node = Node(it)
                if (head == null) {
                    head = node
                }

                cur?.next = node
                cur = node
            }
            cur!!.next = head
            return head
        }
    }
}