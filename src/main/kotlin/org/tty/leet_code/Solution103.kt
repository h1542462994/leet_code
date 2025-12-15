package org.tty.leet_code

import kotlin.concurrent.fixedRateTimer

class Solution103 {
    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        val result = mutableListOf<MutableList<Int>>()
        val queue = ArrayDeque<TreeNode>()

        var direction = 1

        if (root != null) {
            queue.add(root)
        }

        while (true) {
            val length = queue.size
            if (length == 0) {
                break
            }

            result.add(mutableListOf())
            for (i in 0 until length) {
                val cur: TreeNode = if (direction == 1) {
                    queue.removeFirst()
                } else {
                    queue.removeLast()
                }

                result.last().add(cur.`val`)

                if (direction == 1) {
                    if (cur.left != null) {
                        queue.addLast(cur.left!!)
                    }
                    if (cur.right != null) {
                        queue.addLast(cur.right!!)
                    }
                } else {
                    if (cur.right != null) {
                        queue.addFirst(cur.right!!)
                    }
                    if (cur.left != null) {
                        queue.addFirst(cur.left!!)
                    }
                }
            }

            direction = 1 - direction
        }

        return result

    }
}