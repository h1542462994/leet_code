package org.tty.leet_code

class Solution222 {
    fun countNodes(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }

        var n = 0
        val deque = ArrayDeque<TreeNode>()
        deque.add(root)

        while (deque.isNotEmpty()) {
            val cur = deque.removeFirst()
            n++
            if (cur.left != null) {
                deque.add(cur.left!!)
            }
            if (cur.right != null) {
                deque.add(cur.right!!)
            }

        }
        return n
    }
}