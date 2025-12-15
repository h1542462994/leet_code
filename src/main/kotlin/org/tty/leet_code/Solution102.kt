package org.tty.leet_code

class Solution102 {
    fun levelOrder(root: TreeNode?): List<List<Int>> {

        val result = mutableListOf<MutableList<Int>>()
        val queue = mutableListOf<TreeNode>()

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
                val cur = queue.removeFirst()
                result.last().add(cur.`val`)
                if (cur.left != null) {
                    queue.add(cur.left!!)
                }
                if (cur.right != null) {
                    queue.add(cur.right!!)
                }
            }
        }
        return result
    }
}